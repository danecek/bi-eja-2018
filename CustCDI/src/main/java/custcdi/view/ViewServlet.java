package custcdi.view;

import custcdi.business.Facade;
import custcdi.model.Cust;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;

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
        StringBuilder sb = new StringBuilder("</").append(tag);
        return sb.append(">").toString();
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

            out.println("User: " + facade.user().orElse("anonymous"));

            out.print(btag("table", "border", "1"));
            for (Cust item : facade.allCusts()) {
                out.print(btag("tr"));
                out.print(btag("td"));
                out.print(item.getId());
                out.print(etag("td"));
                out.print(btag("td"));
                out.print(item.getName());
                out.print(etag("td"));
                out.print(etag("tr"));
            }
            out.print(etag("table"));

            Set<ConstraintViolation> cvs = (Set<ConstraintViolation>) request.getAttribute("constrantViolations");
            if (cvs != null) {
                cvs.forEach((cv) -> {
                    out.print(cv.getMessage());
                });
            }

            if (facade.user().isPresent()) {
                out.print(btag("form", "action", "addItem.do", "method", "POST"));
                out.print(btag("input", "type", "text", "name", "name"));
                out.print(etag("input"));
                out.print(btag("input", "type", "Submit", "value", "Add"));
                out.print(etag("input"));
                out.print(etag("form"));
            } else {
                out.print("Login");
                out.print(btag("form", "action", "login.do", "method", "POST"));
                out.print(btag("input", "type", "text", "name", "user"));
                out.print(etag("input"));
                out.print(btag("input", "type", "Submit", "value", "Login"));
                out.print(etag("input"));
                out.print(etag("form"));
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
