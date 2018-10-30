package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IntegranteDAO {
    
    private final String TABLE = "Integrantes";
    
    public boolean salvar(Integrante integrante, String nomeBanda) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        
        String sql = "INSERT INTO "+TABLE+"(nome, banda) "
                   + "VALUES (?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, integrante.getNome());
        stmt.setString(2, nomeBanda);
        
        int result = stmt.executeUpdate();
        
        stmt.close();
        conn.close();
        
        return result > 0;
    }
    
    public boolean salvarAll(Banda banda) throws SQLException{
        List<Integrante> integrantes = banda.getIntegrantes();
        boolean result = true;
        for(Integrante i : integrantes){
            if(!salvar(i, banda.getNome())){
                result = false;
            }
        }
        return result;
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
