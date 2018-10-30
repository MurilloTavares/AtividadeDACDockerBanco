package br.edu.ifpb.servlets;

import br.edu.ifpb.dao.BandaDAO;
import br.edu.ifpb.domain.Banda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SalvarBandaServlet", urlPatterns = {"/salvarBandaServlet"})
public class SalvarBandaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nome = req.getParameter("nome");
        String localOrigem = req.getParameter("localOrigem");
        
        String integrantesInput = req.getParameter("integrantes");        
        String[] arrayIntegrantes = integrantesInput.split(",");
        List<String> integrantes = Arrays.asList(arrayIntegrantes);
        
        Banda banda = new Banda(nome, localOrigem, integrantes);
        
        BandaDAO dao = new BandaDAO();
        try {
            dao.salvar(banda);
            req.setAttribute("msg", "Banda salva com sucesso.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            req.setAttribute("msg", ex.getMessage());
        }        
        
        req.getRequestDispatcher("salvarBanda.jsp").forward(req, resp);        
    }

    
    
}
