package br.edu.ifpb.servlets;

import br.edu.ifpb.dao.AlbumDAO;
import br.edu.ifpb.dao.BandaDAO;
import br.edu.ifpb.domain.Album;
import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Estilo;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SalvarAlbumServlet", urlPatterns = {"/salvarAlbumServlet"})
public class SalvarAlbumServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        Estilo estilo = Estilo.valueOf(req.getParameter("estilo"));
        
        BandaDAO bandaDao = new BandaDAO();
        Banda banda = null;
        try {
            banda = bandaDao.buscar(req.getParameter("banda"));
        } catch (SQLException ex) {
            Logger.getLogger(SalvarAlbumServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LocalDate anoLancamento = LocalDate.now();
        System.out.println("Lancamento: "+req.getParameter("anoLancamento"));
        
        Album album = new Album(estilo, banda, anoLancamento);
        
        AlbumDAO albumDao = new AlbumDAO();
        try {
            albumDao.salvar(album);
            req.setAttribute("msg", "Album salvo com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(SalvarAlbumServlet.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("msg", ex.getMessage());
        }
        req.getRequestDispatcher("salvarAlbum.jsp").forward(req, resp);

    }

}
