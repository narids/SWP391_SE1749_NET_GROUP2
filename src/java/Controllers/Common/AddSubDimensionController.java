/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.SubjectDeDAO;
import Models.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author User
 */
@WebServlet(name = "AddSubDimensionController", urlPatterns = {"/addsubdi"})

public class AddSubDimensionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
        request.getRequestDispatcher("jsp/addsubde.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("subdiname");
        String explain = request.getParameter("subdidetail");
        SubjectDeDAO sub = new SubjectDeDAO();
        sub.addnew(content, explain);
        response.sendRedirect("subdelist");
    }

}
