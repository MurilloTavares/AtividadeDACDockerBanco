package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    public boolean deletar(Banda t) throws SQLException {
        return false;
    }

}
