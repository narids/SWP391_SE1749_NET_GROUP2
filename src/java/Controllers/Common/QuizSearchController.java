/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.QuizDAO;
import Models.MyClass;
import Models.Question;
import Models.Quiz;
import Ultils.Pagination;
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
 * @author admin
 */
@WebServlet(name = "QuizSearchController", urlPatterns = {"/quiz-search"})
public class QuizSearchController extends HttpServlet {

    QuizDAO qdao = new QuizDAO();

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
        //Lay keyword va page
        String keyword = request.getParameter("keyword");
        int page = 1;
        int type = 1;
        if (keyword == null) {
            keyword = "";
        }
        String temp = request.getParameter("page");
        if (request.getParameter("page") != null || request.getParameter("page") == "") {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (request.getParameter("type") != null || request.getParameter("type") == "") {
            type = Integer.parseInt(request.getParameter("type"));
        }
        int noOfPages = 1;
        switch (type) {
            case 1:
                List<Quiz> quizzes = qdao.getQuizzes(keyword);
                noOfPages = (int) Math.ceil(quizzes.size() * 1.0 / 12);
                quizzes = new Pagination().paginateRecords(quizzes, page, 12);
                request.setAttribute("quizzes", quizzes);
                break;
            case 3:
                List<Question> questions = qdao.getQuestions(keyword);
                noOfPages = (int) Math.ceil(questions.size() * 1.0 / 10);
                questions = new Pagination().paginateRecords(questions, page, 10);
                request.setAttribute("questions", questions);
                break;
            case 2:
                List<MyClass> classes = qdao.getClasses(keyword);
                noOfPages = (int) Math.ceil(classes.size() * 1.0 / 20);
                classes = new Pagination().paginateRecords(classes, page, 20);
                request.setAttribute("classes", classes);
                break;
            default:
                throw new AssertionError();
        }
        request.setAttribute("keywordSaved", keyword);
        request.setAttribute("pageSaved", page);
        request.setAttribute("typeSaved", type);
        request.setAttribute("noOfPages", noOfPages);
        request.getRequestDispatcher("jsp/quiz-search.jsp").forward(request, response);
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
