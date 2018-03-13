/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletmvc.controller;

import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servletmvc.model.Data;

@WebServlet({"*.do"})
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/addItem.do": {
                String item = request.getParameter("item");
                if (item.isEmpty()) {
                    request.setAttribute("error", "Empty item");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("");
                    rd.forward(request, response);
                    return;
                }
                Data.INST.getData().add(item);
                break;

            }
            case "/login.do": {
                String user = request.getParameter("user");
                if (user.isEmpty()) {
                    request.setAttribute("error", "Empty item");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("");
                    rd.forward(request, response);
                    return;
                }
                request.getSession().setAttribute("user", user);
                break;

            }
            default:
                throw new ServerException("imvalid action");

        }
        response.sendRedirect("");

    }

    @Override
    public String getServletInfo() {
        return "Front contoller";
    }// </editor-fold>

}
