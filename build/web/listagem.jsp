<%@page import="br.edu.ifpb.domain.Album"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpb.domain.Banda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            List<Album> albums = (List<Album>)request.getAttribute("albums");
        %>
        <table>
                <tr>
                    <td>ID</td>
                    <td>Estilo</td>
                    <td>Banda</td>
                    <td>Lancamento</td>
                </tr>
                
                <% for(Album a : albums){ %>
                    <tr>
                        <td><%= a.getId() %></td>
                        <td><%= a.getEstilo().name() %></td>
                        <td><%= a.getBanda().getNome() %></td>
                        <td><%= a.getAnoLancamento() %></td>
                    </tr>           
                <% } %>                
        </table>
        
    </body>
</html>
