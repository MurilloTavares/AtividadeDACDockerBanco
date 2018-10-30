package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BandaDAO {
    
    private final String TABLE = "Banda";
    
    public boolean salvar(Banda banda) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        
        String sql = "INSERT INTO "+TABLE+"(nome, localOrigem) "
                   + "VALUES (?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, banda.getNome());
        stmt.setString(2, banda.getLocalOrigem());
        
        int result = stmt.executeUpdate();
        
        stmt.close();
        conn.close();
        
        return result > 0;
    }
 
    public boolean atualizar(Banda t) throws SQLException {
        return false;
    }

    public List<Banda> buscarAll() throws SQLException {        
        Connection conn = ConnectionFactory.connect();
        
        String sql = "SELECT * FROM "+TABLE;
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        
        List<Banda> bandas = resultToBandas(result);
        
        stmt.close();
        conn.close();
        
        return bandas;
        
    }
    
    public Banda buscar(String nome) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        
        String sql = "SELECT * FROM "+TABLE+" WHERE nome = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet result = stmt.executeQuery();        
        
        IntegranteDAO iDao = new IntegranteDAO();
        
        Banda banda = null;
        if(result.next()){
            banda = new Banda(
                    result.getString("nome"),
                    result.getString("localOrigem"),
                    iDao.buscarAll(result.getString("nome"))
            );
        }
        stmt.close();
        conn.close();
        
        return banda;
    }

    public boolean deletar(Banda t) throws SQLException {
        return false;
    }
    
    private List<Banda> resultToBandas(ResultSet result) throws SQLException{
        List<Banda> bandas = new ArrayList<>();
        
        IntegranteDAO iDao = new IntegranteDAO();
        
        while(result.next()){
            
            Banda banda = new Banda(
                    result.getString("nome"),
                    result.getString("localOrigem"),
                    iDao.buscarAll(result.getString("nome"))
            );
            bandas.add(banda);
        }
        
        return bandas;
    }

}
