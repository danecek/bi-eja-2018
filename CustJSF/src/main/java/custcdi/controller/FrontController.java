/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.controller;

import java.io.IOException;
import java.rmi.ServerException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"*.do"})
public class FrontController extends HttpServlet {

    @Inject
    @AddCustQ
    CustAction addCust;
    @Inject
    @LoginQ
    CustAction login;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/addItem.do": {
                addCust.execute();
                break;

            }
            case "/login.do": {
                login.execute();
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
