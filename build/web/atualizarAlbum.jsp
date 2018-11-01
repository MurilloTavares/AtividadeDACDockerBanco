<%@page import="java.util.List"%>
<%@page import="br.edu.ifpb.domain.Banda"%>
<%@page import="br.edu.ifpb.domain.Estilo"%>
<%@page import="br.edu.ifpb.domain.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Album</title>
    </head>
    <body>
        <% 
            Album album = (Album)request.getAttribute("album"); 
            List<Banda> bandas = (List<Banda>)request.getAttribute("bandas");
        %>
        ${msg}
        <form action="atualizarServlet" method="POST">
            <table>
                <tr>
                    <td><label> ID </label></td>
                    <td><p><%= album.getId() %></p>
                    <input type="hidden" name="id" value="<%= album.getId() %>"/>
                </tr>
                <tr>
                    <td><label>Estilo: </label></td>
                    <td>
                        <select name="estilo">
                            <% for(Estilo e : Estilo.values()){ %>
                                <option value="<%= e.name() %>"
                                        <%
                                            if(e.equals(album.getEstilo())){
                                                out.print(" selected ");
                                            }
                                        %> >
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
                                <option value="<%= banda.getNome() %>" 
                                        <% 
                                            if(banda.getNome().equals(album.getBanda().getNome())){
                                                out.print(" selected ");
                                            }
                                        %> >
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
                <input type="submit" value="Atualizar" />
            </table>
        </form>
    </body>
</html>
