package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Album;
import br.edu.ifpb.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    public boolean atualizar(Album a) throws SQLException {
        return false;
    }

    public boolean deletar(Album a) throws SQLException {
        return false;
    }
    
}
