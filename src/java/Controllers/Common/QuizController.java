/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import DAOs.QuestionDAO;
import DAOs.QuizDAO;
import Models.Account;
import Models.ClassSubject;
import Models.Question;
import Models.Quiz;
import Models.Student;
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
 * @author owner
 */
@WebServlet(name = "QuizController", urlPatterns = {"/quizzes"})
public class QuizController extends HttpServlet {

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
            out.println("<title>Servlet QuizController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        AccountDAO adb = new AccountDAO();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
            QuizDAO quizDAO = new QuizDAO();
            String id = request.getParameter("quizID");

            if (id != null && !id.isEmpty()) {
                String sql = "SELECT Quiz.QuizID, Quiz.QuizName, Quiz.QuizContent, Quiz.CreatedDate, Quiz.QuizStatus, Class.ClassName, Subject.SubjectName, Teacher.TeacherID, Class.ClassID, Subject.SubjectID\n"
                        + "FROM         Class INNER JOIN\n"
                        + "                      ClassSubject ON Class.ClassID = ClassSubject.ClassID INNER JOIN\n"
                        + "                      Subject ON ClassSubject.SubjectID = Subject.SubjectID INNER JOIN\n"
                        + "                      Teacher ON ClassSubject.TeacherID = Teacher.TeacherID INNER JOIN\n"
                        + "                      Quiz ON ClassSubject.QuizID = Quiz.QuizID\n"
                        + "                      where ";

                switch (account.getRole().getRoleId()) {
                    case 3: // teacher
                        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
                        sql = sql + " Teacher.TeacherID =" + String.valueOf(teacher.getTeacherId());

                        break;
                    case 4: // student
                        Student student = (Student) request.getSession().getAttribute("student");
                        sql = "SELECT    Quiz.QuizID, Quiz.QuizName, Quiz.QuizContent, Quiz.CreatedDate, Quiz.QuizStatus, Class.ClassName, Subject.SubjectName, Teacher.TeacherID, Student.StudentID, Class.ClassID, Subject.SubjectID\n"
                                + "FROM         ClassStudent INNER JOIN\n"
                                + "Class ON ClassStudent.ClassID = Class.ClassID INNER JOIN\n"
                                + "ClassSubject ON Class.ClassID = ClassSubject.ClassID INNER JOIN\n"
                                + "Quiz ON ClassSubject.QuizID = Quiz.QuizID INNER JOIN\n"
                                + "Student ON ClassStudent.StudentID = Student.StudentID INNER JOIN\n"
                                + "Subject ON ClassSubject.SubjectID = Subject.SubjectID INNER JOIN\n"
                                + "Teacher ON ClassSubject.TeacherID = Teacher.TeacherID\n"
                                + "where Quiz.QuizStatus = 1 and Student.StudentID =";

                        sql += String.valueOf(student.getStudentId());
                        break;
                }

                sql = sql + " and Quiz.QuizID = '" + id + "'";

                List<ClassSubject> quizzes;
                if (account.getRole().getRoleId() != 4) {
                    quizzes = quizDAO.getQuizzesByTeacherID(sql);
                } else {
                    quizzes = quizDAO.getQuizzesByStudentID(sql);
                }

                if (quizzes != null && quizzes.size() > 0) {
                    QuestionDAO questionDAO = new QuestionDAO();
                    
                    ClassSubject quiz = quizzes.get(0);
                    List<Question> questions = questionDAO.getQuestionAndAnswersByQuizId(id);
                    
                    request.setAttribute("teacherFullname", adb.getTeacherFullname(Integer.parseInt(quizzes.get(0).getTeacher().getTeacherId())));
                    request.setAttribute("quiz", quiz);
                    request.setAttribute("questions", questions);
                    request.getRequestDispatcher("jsp/quizDetail.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("jsp/quiz.jsp").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("jsp/quiz.jsp").forward(request, response);

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
