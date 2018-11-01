package br.edu.ifpb.servlets;

import br.edu.ifpb.dao.AlbumDAO;
import br.edu.ifpb.domain.Album;
import br.edu.ifpb.domain.Banda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listarServlet", urlPatterns = {"/listarServlet"})
public class ListarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AlbumDAO dao = new AlbumDAO();
        try {
            dao.deletar(id);
        } catch (SQLException ex) {
            Logger.getLogger(ListarServlet.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("msg", ex.getMessage());
        }
        resp.sendRedirect("listarServlet");
        //req.getRequestDispatcher("listagem.jsp").forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        AlbumDAO dao = new AlbumDAO();
        try {
            List<Album> albums = dao.buscarAll();
            req.setAttribute("albums", albums);
            req.getRequestDispatcher("listagem.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(ListarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
    
    
}
