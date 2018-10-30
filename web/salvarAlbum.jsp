<%@page import="br.edu.ifpb.domain.Estilo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpb.domain.Banda"%>
<%@page import="br.edu.ifpb.dao.BandaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salvar Album</title>
    </head>
    <body>
        <%
            BandaDAO bandaDao = new BandaDAO();
            List<Banda> bandas = bandaDao.buscarAll();  
        %>
        ${msg}
        <h2>Salvar Album</h2>
        <form action="salvarAlbumServlet" method="POST">
            <table>
                <tr>
                    <td><label>Estilo: </label></td>
                    <td>
                        <select name="estilo">
                            <% for(Estilo e : Estilo.values()){ %>
                                <option value="<%= e.name() %>">
                                    <%= e.name() %>
                                </option>
                            <% } %>                        
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Banda: </label></td>
                    <td>
                        <select name="banda">
                            <% for(Banda banda : bandas){ %>
                                <option value="<%= banda.getNome() %>">
                                    <%= banda.getNome() %>
                                </option>
                            <% } %>                        
                        </select>
                    </td>
                </tr>    
                
                <tr>
                    <td><label>Ano de Lancamento: </label></td>
                    <td><input name="anoLancamento" type="date"/></td>
                </tr>
            </table>
            <input type="submit" value="Salvar" />
        </form>        
    </body>
</html>
