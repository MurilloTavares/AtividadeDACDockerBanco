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
        ${msg}
        <table>
                <tr>
                    <td> - </td>
                    <td>ID</td>
                    <td>Estilo</td>
                    <td>Banda</td>
                    <td>Lancamento</td>
                    <td> - </td>
                </tr>
                
                <% for(Album a : albums){ %>
                    <tr>
                        <td>
                            <form action="atualizarServlet" method="GET">
                                <input type="hidden" value="<%= a.getId() %>" name="id" />
                                <input type="submit" value="Atualizar" />
                            </form>                            
                        </td>
                        <td><%= a.getId() %></td>
                        <td><%= a.getEstilo().name() %></td>
                        <td><%= a.getBanda().getNome() %></td>
                        <td><%= a.getAnoLancamento() %></td>
                        <td>
                            <form action="listarServlet" method="POST" >
                                <input type="hidden" value="<%= a.getId() %>" name="id"/>
                                <input type="submit" value="Deletar" />
                            </form>                            
                        </td>
                    </tr>          
                <% } %>                
        </table>
        
    </body>
</html>
