/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AnswerDAO;
import DAOs.QuestionDAO;
import DAOs.QuizDAO;
import DAOs.TestDAO;
import Models.Question;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author win
 */
@WebServlet(name = "QuizReviewController", urlPatterns = {"/quiz-review"})
public class QuizReviewController extends HttpServlet {

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
        QuestionDAO qtdao = new QuestionDAO();
        QuizDAO qdao = new QuizDAO();
        TestDAO tdao = new TestDAO(); 
        AnswerDAO adao = new AnswerDAO();
        int scoreId = Integer.parseInt(request.getParameter("scoreId"));
        int quizId = tdao.getTestById(scoreId).getQuizId();
        List<Question> ltQuestion = qtdao.getQuestionByQuiz(quizId);
        String[] selectedAnswers = adao.getSelectedAnswerByScore(scoreId);
        request.setAttribute("ltQuestion", ltQuestion);
        request.setAttribute("quizId", quizId);
        request.setAttribute("quiz", qdao.getQuizById(quizId));
        request.setAttribute("selectedAnswers", selectedAnswers);
        request.setAttribute("score", tdao.getTestById(scoreId).getScore());
        request.setAttribute("time", tdao.getTestById(scoreId).getTime());
        request.getRequestDispatcher("jsp/quiz-review.jsp").forward(request, response);
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
