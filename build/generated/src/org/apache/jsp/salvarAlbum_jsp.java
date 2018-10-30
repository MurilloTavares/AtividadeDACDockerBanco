package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.edu.ifpb.domain.Estilo;
import java.util.List;
import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.dao.BandaDAO;

public final class salvarAlbum_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Salvar Album</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            BandaDAO bandaDao = new BandaDAO();
            List<Banda> bandas = bandaDao.buscarAll();  
        
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        <h2>Salvar Album</h2>\n");
      out.write("        <form action=\"salvarAlbumServlet\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label>Estilo: </label></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"estilo\">\n");
      out.write("                            ");
 for(Estilo e : Estilo.values()){ 
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( e.name() );
      out.write("\">\n");
      out.write("                                    ");
      out.print( e.name() );
      out.write("\n");
      out.write("                                </option>\n");
      out.write("                            ");
 } 
      out.write("                        \n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label>Banda: </label></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"banda\">\n");
      out.write("                            ");
 for(Banda banda : bandas){ 
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( banda.getNome() );
      out.write("\">\n");
      out.write("                                    ");
      out.print( banda.getNome() );
      out.write("\n");
      out.write("                                </option>\n");
      out.write("                            ");
 } 
      out.write("                        \n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>    \n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td><label>Ano de Lancamento: </label></td>\n");
      out.write("                    <td><input name=\"anoLancamento\" type=\"date\"/></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"Salvar\" />\n");
      out.write("        </form>        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
