/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

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
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "AddSubjectController", urlPatterns = {"/addsubject"})

public class AddSubjectController extends HttpServlet {

    SubjectDAO queD = new SubjectDAO();
    SubjectDeDAO subD = new SubjectDeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
            if (account.getRole().getRoleId() == 3 || account.getRole().getRoleId() == 2) {
                int id = Integer.parseInt(request.getParameter("subjectdeid"));
                SubjectDimension subdi = subD.getbyIDfull(id);
                request.setAttribute("subjectdimension", subdi);
                request.getRequestDispatcher("jsp/addsubject.jsp").forward(request, response);
            } else {
                response.sendRedirect("home");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("addsubjectname");
        String explain = request.getParameter("addsubjectdetail");
        String id = request.getParameter("subjectdiid");
        queD.addSubject(explain, explain, id);
        response.sendRedirect("subjectlist?subjectdeid=" + id);
    }
}
