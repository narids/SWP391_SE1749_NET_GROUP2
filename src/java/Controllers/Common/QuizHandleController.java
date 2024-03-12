/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AnswerDAO;
import DAOs.QuestionDAO;
import DAOs.QuizDAO;
import Models.Account;
import Models.Question;
import Models.Quiz;
import Ultils.ConvertTime;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author win
 */
@WebServlet(name = "QuizHandleController", urlPatterns = {"/quiz-handle"})
public class QuizHandleController extends HttpServlet {

    QuizDAO qdao = new QuizDAO();
    QuestionDAO qtdao = new QuestionDAO();
    AnswerDAO adao = new AnswerDAO();

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
        String quizIdRaw = request.getParameter("quizId");
        int quizId = Integer.parseInt(quizIdRaw);
        Quiz quiz = qdao.getQuizById(quizIdRaw);
        List<Question> ltQuestion = qtdao.getQuestionByQuiz(quizId);
        request.setAttribute("ltQuestion", ltQuestion);
        request.setAttribute("quizId", quizId);
        request.setAttribute("quiz", quiz);
        request.getRequestDispatcher("jsp/quiz-handle.jsp").forward(request, response);
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
        float score = 0;
        Account a = (Account) request.getSession().getAttribute("account");
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        String[] selectedAnswers = request.getParameterValues("answers");
        int time = Integer.parseInt(request.getParameter("time"));

        if (selectedAnswers != null) {
            // Calculate the score
            score = adao.countScore(selectedAnswers, quizId);
        }
        System.out.println(score);
        int scoreId = qdao.setScore(
                quizId,
                a.getUserId(),
                score,
                qdao.getQuizById(quizId).getTime() - time);
        if (selectedAnswers != null) {
            adao.setSelectedAnswers(selectedAnswers, scoreId);
        }
        response.sendRedirect("quiz-review?scoreId=" + scoreId);
//        // Get questions for the quiz
//        List<Question> ltQuestion = qtdao.getQuestionByQuiz(quizId);
//        
//        // Set attributes for forwarding to the JSP
//        request.setAttribute("ltQuestion", ltQuestion);
//        request.setAttribute("quizId", quizId);
//        request.setAttribute("quiz", qdao.getQuizById(request.getParameter("quizId")));
//        request.setAttribute("selectedAnswers", selectedAnswers);
//        request.setAttribute("score", score);
//
//        // Forward the request to the quiz-review.jsp
//        request.getRequestDispatcher("quiz-review.jsp").forward(request, response);
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
