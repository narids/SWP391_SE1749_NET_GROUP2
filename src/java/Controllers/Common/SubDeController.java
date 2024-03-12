/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.SubjectDeDAO;
import Models.Account;
import Models.SubjectDimension;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "SubDeController", urlPatterns = {"/subdelist"})

public class SubDeController extends HttpServlet{
        SubjectDeDAO queD = new SubjectDeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
        List<SubjectDimension> lst = queD.list();
        request.setAttribute("subdelist", lst);
        request.getRequestDispatcher("jsp/subDeList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("todo");
        switch (action) {
            case "delete":
                int id = Integer.parseInt(request.getParameter("subDeId"));
                queD.deleteByID(id);
                response.sendRedirect("subdelist");
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
