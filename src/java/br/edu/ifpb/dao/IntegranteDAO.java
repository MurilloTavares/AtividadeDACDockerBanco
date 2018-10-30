package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public List<Integrante> buscarAll(String nomeBanda) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        
        String sql = "SELECT * FROM "+TABLE+ " WHERE Banda = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeBanda);
        ResultSet result = stmt.executeQuery();
        
        List<Integrante> bandas = resultToIntegrantes(result);
        
        stmt.close();
        conn.close();
        
        return bandas;
    }

    private List<Integrante> resultToIntegrantes(ResultSet result) throws SQLException{
        List<Integrante> integrantes = new ArrayList<>();
        while(result.next()){
            Integrante i = new Integrante(result.getString("nome"));
            integrantes.add(i);
        }
        return integrantes;
    }
    
    public boolean deletar(Banda t) throws SQLException {
        return false;
    }
    
}
