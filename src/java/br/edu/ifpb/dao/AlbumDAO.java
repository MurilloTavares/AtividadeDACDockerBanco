package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Album;
import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Estilo;
import br.edu.ifpb.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    
    private final String TABLE = "Album";
    
    public boolean salvar(Album album) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        
        String sql = "INSERT INTO "+TABLE+"(estilo, banda, anoLancamento) "
                   + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, album.getEstilo().name());
        stmt.setString(2, album.getBanda().getNome());
        stmt.setDate(3, Date.valueOf(album.getAnoLancamento()));
        
        int result = stmt.executeUpdate();
        
        stmt.close();
        conn.close();
        
        return result > 0;        
    }

    public List<Album> buscarAll() throws SQLException {
        List<Album> albums = new ArrayList<>();
        Connection conn = ConnectionFactory.connect();
        
        String sql = "SELECT * FROM "+TABLE;
        Statement stmt = conn.createStatement();
        
        ResultSet result = stmt.executeQuery(sql);        
        BandaDAO bandaDao = new BandaDAO();
        
        while(result.next()){
            int id = result.getInt("id");
            Estilo estilo = Estilo.valueOf(result.getString("estilo"));
            Banda banda = bandaDao.buscar(result.getString("banda"));
            LocalDate anoLancamento = result.getDate("anoLancamento").toLocalDate();
            
            Album album = new Album(id, estilo, banda, anoLancamento);
            albums.add(album);            
        }
        
        return albums;
    }
    
    public Album buscar(int _id) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        String sql = "SELECT * FROM "+TABLE+" WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, _id);
        ResultSet result = stmt.executeQuery();
        Album album = null;
        while(result.next()){
            BandaDAO bandaDao = new BandaDAO();
            int id = result.getInt("id");
            Estilo estilo = Estilo.valueOf(result.getString("estilo"));
            Banda banda = bandaDao.buscar(result.getString("banda"));
            LocalDate anoLancamento = result.getDate("anoLancamento").toLocalDate();
            
            album = new Album(id, estilo, banda, anoLancamento);            
        }
        return album;
    }
    
    public boolean atualizar(Album album) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        
        String sql = "UPDATE "+TABLE+" SET estilo = ?, banda =  ?, anoLancamento = ? "
                   + "WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, album.getEstilo().name());
        stmt.setString(2, album.getBanda().getNome());
        stmt.setDate(3, Date.valueOf(album.getAnoLancamento()));
        stmt.setInt(4, album.getId());
        int result = stmt.executeUpdate();
        
        stmt.close();
        conn.close();
        
        return result > 0;        
    }
    
    public boolean deletar(int id) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        String sql = "DELETE FROM "+TABLE+" WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int result = stmt.executeUpdate();
        return result > 0;
    }
    
}
