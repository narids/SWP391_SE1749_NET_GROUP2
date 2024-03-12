/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import DAOs.QuizDAO;
import DAOs.StudentDAO;
import Models.Account;
import Models.ClassSubject;
import jakarta.servlet.RequestDispatcher;
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
 * @author nghia
 */
@WebServlet(name = "StudentProfileController", urlPatterns = {"/StudentProfile"})
public class StudentProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentProfileController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
//        processRequest(request, response);
        int studentID = Integer.parseInt(request.getParameter("studentId")); 
        
        StudentDAO st = new StudentDAO();
        Account account = st.getAccountByStudentID(studentID);
        request.setAttribute("account", account);
        AccountDAO accDao = new AccountDAO();
        if (account == null) {
            response.sendRedirect("login");
        } else {
            if (account.getRole().getRoleId() == 3) {
                QuizDAO quizDAO = new QuizDAO();

                String quizzesByTeacherIDSQL = "SELECT Quiz.QuizID, Quiz.QuizName, Quiz.QuizContent, Quiz.CreatedDate, Quiz.QuizStatus, Class.ClassName, Subject.SubjectName, Teacher.TeacherID, Class.ClassID, Subject.SubjectID\n"
                        + "FROM         Class INNER JOIN\n"
                        + "                      ClassSubject ON Class.ClassID = ClassSubject.ClassID INNER JOIN\n"
                        + "                      Subject ON ClassSubject.SubjectID = Subject.SubjectID INNER JOIN\n"
                        + "                      Teacher ON ClassSubject.TeacherID = Teacher.TeacherID INNER JOIN\n"
                        + "                      Quiz ON ClassSubject.QuizID = Quiz.QuizID\n"
                        + "			where Teacher.TeacherID = " + String.valueOf(accDao.getTeacherByUserID(account.getUserId()));

                List<ClassSubject> quizzesByTeacherID = quizDAO.getQuizzesByTeacherID(quizzesByTeacherIDSQL);

                request.setAttribute("quizlist", quizzesByTeacherID);
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/teacherProfile.jsp");
                dispatcher.forward(request, response);

            }

            if (account.getRole().getRoleId() == 4) {
                QuizDAO quizDAO = new QuizDAO();

                String quizzesByStudentIDSQL = "SELECT    Quiz.QuizID, Quiz.QuizName, Quiz.QuizContent, Quiz.CreatedDate, Quiz.QuizStatus, Class.ClassName, Subject.SubjectName, Teacher.TeacherID, Student.StudentID, Class.ClassID, Subject.SubjectID\n"
                        + "FROM         ClassStudent INNER JOIN\n"
                        + "Class ON ClassStudent.ClassID = Class.ClassID INNER JOIN\n"
                        + "ClassSubject ON Class.ClassID = ClassSubject.ClassID INNER JOIN\n"
                        + "Quiz ON ClassSubject.QuizID = Quiz.QuizID INNER JOIN\n"
                        + "Student ON ClassStudent.StudentID = Student.StudentID INNER JOIN\n"
                        + "Subject ON ClassSubject.SubjectID = Subject.SubjectID INNER JOIN\n"
                        + "Teacher ON ClassSubject.TeacherID = Teacher.TeacherID\n"
                        + "where Quiz.QuizStatus = 1 and Student.StudentID = " + String.valueOf(accDao.getStudentByUserID(account.getUserId()));

                List<ClassSubject> quizzesByStudentID = quizDAO.getQuizzesByStudentID(quizzesByStudentIDSQL);

                request.setAttribute("quizlist", quizzesByStudentID);
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/studentProfile.jsp");
                dispatcher.forward(request, response);
            }

            
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
