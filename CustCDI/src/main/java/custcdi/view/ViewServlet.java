package custcdi.view;

import custcdi.business.Facade;
import custcdi.model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({""})
public class ViewServlet extends HttpServlet {

    @Inject
    Facade facade;

    static String btag(String tag, String... attrs) {
        StringBuilder sb = new StringBuilder("<").append(tag);
        for (int i = 0; i < attrs.length; i += 2) {
            sb.append(" ").append(attrs[i]).append("=\"").append(attrs[i + 1]).append("\"");
        }
        return sb.append(">").toString();
    }

    static String etag(String tag) {
        return new StringBuilder("</").append(tag).append(">").toString();
    }

    static String closedtag(String tag, String... attrs) {
        StringBuilder sb = new StringBuilder("<").append(tag);
        for (int i = 0; i < attrs.length; i += 2) {
            sb.append(" ").append(attrs[i]).append("=\"").append(attrs[i + 1]).append("\"");
        }
        return sb.append("/>").toString();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Data</h1>");
            Optional<String> user = facade.user();

            out.println("User: " + user.orElse("anonym"));
            out.println(btag("hr"));

            out.println(btag("table", "border", "1"));
            for (Customer item : facade.all()) {
                out.println(btag("tr"));
                out.println(btag("td"));
                out.println(item.getId());
                out.println(etag("td"));
                out.println(btag("td"));
                out.println(item.getName());
                out.println(etag("td"));
                out.println(etag("tr"));
            }
            out.println(etag("table"));

            out.println(btag("hr"));

            if (user.isPresent()) {
                out.println("Add user");
                out.println(btag("form", "action", "addItem.do", "method", "POST"));
                out.println(closedtag("input", "type", "text", "name", "item"));
                out.println(closedtag("input", "type", "Submit", "value", "Add"));
                out.println(etag("form"));
                Object mess = request.getAttribute("error");
                if (mess != null) {
                    out.print(mess);
                }
            } else {
                out.println("Login");
                out.println(btag("form", "action", "login.do", "method", "POST"));
                out.println(closedtag("input", "type", "text", "name", "user"));
                out.println(closedtag("input", "type", "Submit", "value", "Login"));
                out.println(etag("form"));
                Object mess = request.getAttribute("error");
                if (mess != null) {
                    out.print(mess);
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
