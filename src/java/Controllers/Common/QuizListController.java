/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.SubjectDAO;
import Models.Account;
import Models.ClassSubject;
import Models.Subject;
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
@WebServlet(name = "QuizListController", urlPatterns = {"/quizlist"})

public class QuizListController extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
        SubjectDAO subD = new SubjectDAO();
        String id = request.getParameter("subjectid");
        List<ClassSubject> lst = subD.getlistQuiz(id);
        request.setAttribute("quizlistbyid", lst);
        request.getRequestDispatcher("jsp/quizlist.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
