/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import DAOs.QuizDAO;
import Models.Account;
import Models.ClassSubject;
import Models.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "CatalogController", urlPatterns = {"/catalog"})
public class CatalogController extends HttpServlet {

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
        Account account = (Account) request.getSession().getAttribute("account");
        if (account == null) {
            response.sendRedirect("login");
        } else {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");

            if (teacher != null) {
                QuizDAO quizDAO = new QuizDAO();
                
                String quizzesByTeacherIDSQL = "SELECT    Quiz.QuizID, Quiz.QuizName, Quiz.QuizContent, Quiz.CreatedDate, Class.ClassName, Subject.SubjectName, Quiz.QuizStatus\n"
                        + "FROM         Class INNER JOIN\n"
                        + "                      ClassSubject ON Class.ClassID = ClassSubject.ClassID INNER JOIN\n"
                        + "                      Subject ON ClassSubject.SubjectID = Subject.SubjectID INNER JOIN\n"
                        + "                      Teacher ON ClassSubject.TeacherID = Teacher.TeacherID INNER JOIN\n"
                        + "                      Quiz ON ClassSubject.QuizID = Quiz.QuizID\n"
                        + "					  where Teacher.TeacherID = " + String.valueOf(teacher.getTeacherId());
                
                List<ClassSubject> quizzesByTeacherID = quizDAO.getQuizzesByTeacherID(quizzesByTeacherIDSQL);
                
                request.setAttribute("quizByTeacher", quizzesByTeacherID);

            }
            request.setAttribute("account", account);
            request.getRequestDispatcher("jsp/catalog.jsp").forward(request, response);

        }
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
        HttpSession session = request.getSession();
        AccountDAO adb = new AccountDAO();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
            String action = request.getParameter("action");

            if ("changePassForm".equals(action)) {
                String currentPassword = request.getParameter("currentPassword");
                String newPassword = request.getParameter("newPassword");
                String confirmPassword = request.getParameter("confirmPassword");

                if (currentPassword.equals(newPassword)) {
                    try (PrintWriter out = response.getWriter()) {
                        out.print("duplicate");
                    }

                } else if (!newPassword.equals(confirmPassword)) {
                    try (PrintWriter out = response.getWriter()) {
                        out.print("notMatch");
                    }

                } else {
                    Account accCheck = adb.getAccount(account.getUsername(), currentPassword);

                    if (accCheck == null) {
                        try (PrintWriter out = response.getWriter()) {
                            out.print("passNotCorrect");
                        }
                    } else {
                        adb.resetPass(newPassword, account.getEmail());

                        try (PrintWriter out = response.getWriter()) {
                            out.print("success");
                        }
                    }

                }

            }

        }
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
