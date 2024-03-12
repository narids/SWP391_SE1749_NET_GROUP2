/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import DAOs.SubjectDAO;
import DAOs.SubjectDeDAO;
import Models.Account;
import Models.Subject;
import Models.SubjectDimension;
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
@WebServlet(name = "SubjectDetailController", urlPatterns = {"/subjectdetail"})

public class SubjectDetailController extends HttpServlet{
    SubjectDAO subde = new SubjectDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
        int id = Integer.parseInt(request.getParameter("subjectid"));
        Subject subd = subde.getbyID(id);
        request.setAttribute("subjectdetail", subd);
        request.getRequestDispatcher("jsp/subjectdetail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("subname");
        String explain = request.getParameter("subdetail");
        int id = Integer.parseInt(request.getParameter("subjectid"));
                        String deid = String.valueOf(subde.getIDbyID(id));
        subde.updateSubject(content, explain, id);
        response.sendRedirect("subjectlist?subjectdeid="+deid);
    }
}
