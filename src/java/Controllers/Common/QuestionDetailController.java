/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.AnswerDAO;
import DAOs.QuestionDAO;
import DAOs.SubjectDAO;
import Models.Account;
import Models.Answer;
import Models.Question;
import Models.Subject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
@WebServlet(name = "QuestionDetailController", urlPatterns = {"/questiondetail"})

public class QuestionDetailController extends HttpServlet {
                QuestionDAO qued = new QuestionDAO();
                                AnswerDAO an = new AnswerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
            if (account.getRole().getRoleId() == 3 || account.getRole().getRoleId() == 2) {
                SubjectDAO subD = new SubjectDAO();
                List<Subject> lst = subD.list();
                request.setAttribute("sublistt", lst);
                String id = request.getParameter("questionid");
                                request.setAttribute("questionid", id);
                Question que = qued.getbyId(id);
                request.setAttribute("questiondetail", que);
                
                request.getRequestDispatcher("jsp/questiondetail.jsp").forward(request, response);
            } else {
                response.sendRedirect("home");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("questioniddetail");
        int id = Integer.parseInt(request.getParameter("questioniddetail"));
        String content = request.getParameter("quescontentdetail");
        String explain = request.getParameter("quesexplaindetail");
        String subject = request.getParameter("subjectdetail");
        String[] options = request.getParameterValues("options[]");
        String[] correctAnswers = request.getParameterValues("corrects[]");
        an.deleteByID(id);
                    try {
                        qued.updateByID(content, explain, subject, ID);
                    } catch (SQLException ex) {
                        Logger.getLogger(QuestionDetailController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // Insert options into the database
                    for (int i = 0; i < options.length; i++) {
                        String optionText = options[i];
                        boolean isCorrect = (correctAnswers != null && correctAnswers.length > 0 && correctAnswers[i].equals(String.valueOf(i + 1)));
                        // SQL query to insert option
                        an.addAnswer(optionText, isCorrect, id);
                    }
        response.sendRedirect("questionbank");
    }
}
