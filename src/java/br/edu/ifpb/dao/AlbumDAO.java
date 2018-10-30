package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Album;
import br.edu.ifpb.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AlbumDAO {
    
    public boolean salvar(Album a) throws SQLException {
        Connection conn = ConnectionFactory.connect();
        
        
        
        return false;        
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
