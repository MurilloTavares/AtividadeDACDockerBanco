package br.edu.ifpb.servlets;

import br.edu.ifpb.dao.AlbumDAO;
import br.edu.ifpb.dao.BandaDAO;
import br.edu.ifpb.domain.Album;
import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Estilo;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "AtualizarServlet", urlPatterns = {"/atualizarServlet"})
public class AtualizarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AlbumDAO aDao = new AlbumDAO();
        Album album = new Album();
        try {
            album = aDao.buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        BandaDAO bDao = new BandaDAO();
        List<Banda> bandas = null;
        try {
            bandas = bDao.buscarAll();
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.setAttribute("album", album);
        req.setAttribute("bandas", bandas);
        req.getRequestDispatcher("atualizarAlbum.jsp").forward(req, resp);

    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        
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
        
        Album album = new Album(id, estilo, banda, anoLancamento);
        
        AlbumDAO albumDao = new AlbumDAO();
        try {
            albumDao.atualizar(album);
            req.setAttribute("msg", "Album salvo com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(SalvarAlbumServlet.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("msg", ex.getMessage());
        }
        
        resp.sendRedirect("listarServlet");

    }
}
