<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salvar Banda</title>
    </head>
    <body>
        ${msg}
        <h2>Salvar Banda</h2>
        <form action="salvarBandaServlet" method="POST">
            <table>
                <tr>
                    <td><label>Nome: </label></td>
                    <td><input name="nome" type="text" /></td>
                </tr>
                <tr>
                    <td><label>Local de Origem: </label></td>
                    <td><input name="localOrigem" type="text" /></td>
                </tr>
                <tr>
                    <td><label>Integrantes: </label></td>
                    <td><input name="integrantes" type="text"
                               placeholder="Ex.: Joao, Maria, Carlos"/></td>
                </tr>
            </table>
            <input type="submit" value="Salvar" />
        </form>        
    </body>
</html>
