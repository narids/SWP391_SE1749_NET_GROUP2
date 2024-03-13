/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import DAOs.QuestionDAO;
import DAOs.QuizDAO;
import Models.Account;
import Models.Answer;
import Models.ClassSubject;
import Models.Question;
import Models.Quiz;
import Models.Student;
import Models.Teacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

                    request.setAttribute("teacherFullname", adb.getTeacherFullname((quizzes.get(0).getTeacher().getTeacherId())));
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
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
            QuizDAO quizDAO = new QuizDAO();

            String action = request.getParameter("action");
            String quizID = request.getParameter("quizID");
            String questionID = request.getParameter("questionID");
            String subjectId = request.getParameter("subjectId");
            String countQuestionUpdate = request.getParameter("countQuestionUpdate");

            try (PrintWriter out = response.getWriter()) {
                switch (action) {
                    case "getQuestion":
                        Question q = quizDAO.getQuestionById(questionID);

                        if (q != null) {
                            List<Answer> answers = q.getAnswers();
                            int index = 1;
                            String showAddBtn = answers.size() > 6 ? " display: none;" : "";

                            out.print("<div class=\"row placeani\">\n"
                                    + "                                    <div class=\"col-lg-12\">\n"
                                    + "                                        <div class=\"form-group\">\n"
                                    + "                                            <div class=\"\">Question:</div>\n"
                                    + "                                            <div class=\"input-group\">\n"
                                    + "                                                <input id='questionInput' name=\"question\" placeholder=\"Enter question\" value='" + q.getQuestionContent() + "' minlength=\"6\" type=\"text\" required class=\"form-control\">\n"
                                    + "                                                <div class=\"invalid-feedback\">\n"
                                    + "                                                    Question must least 6 char\n"
                                    + "                                                </div>\n"
                                    + "                                            </div>\n"
                                    + "                                        </div>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                                <div class=\"row placeani\">\n"
                                    + "                                        <div class=\"col-lg-12\" style=\"display: flex; align-items: center; justify-content: space-between; margin-bottom: 10px\">\n"
                                    + "                                            <div>Answers:</div>\n"
                                    + "                                            <a class=\"btn radius-xl text-uppercase\" style=\"font-size: 10px;" + showAddBtn + " padding: 7px 15px;\" onclick='addAnswerInUpdateModal()' id=\"addAnswer\">Add answer</a>\n"
                                    + "                                        </div>"
                                    + "                                    <div id=\"answersWrapper\" class=\"col-lg-12\" style='overflow-y: auto; height: 176px;'>\n"
                            );

                            for (Answer a : answers) {
                                String checked = a.isIsCorrect() ? "checked" : "";
                                char type = (char) ('A' + index - 1);
                                out.print("<div class=\"form-group\" style=\"display: flex; align-items: center; gap: 17px;\">\n"
                                        + "                                            <input type=\"text\" hidden name='answerID' value='" + a.getAnswerId() + "' class=\"answerID\">\n"
                                        + "                                            <input " + checked + " type=\"checkbox\" id=\"option1\" name=\"options[]\" class=\"checkbox\">\n"
                                        + "                                            <span>" + type + ",</span>\n"
                                        + "                                            <span class=\"input-group\">\n"
                                        + "                                                <input name=\"answer\" placeholder=\"Enter answer\" value='" + a.getAnswerContent() + "' minlength=\"6\" type=\"text\" required class=\"form-control\">\n"
                                        + "                                                <div class=\"invalid-feedback\">\n"
                                        + "                                                    Answer must least 6 char\n"
                                        + "                                                </div>\n"
                                        + "                                            </span>\n"
                                        + "                                            <i onclick='removeAnswer(" + index + ")' style='cursor:pointer; color: red;' class=\"bi bi-dash-circle-fill deleteAnswer\"></i>\n"
                                        + "                                        </div>");

                                index++;
                            }

                            out.print("</div>\n"
                                    + "                                </div>");
                        } else {
                            out.print("faild");
                        }

                        break;
                    case "updateQuiz":
                        String quizName = request.getParameter("quizName");
                        String quizContent = request.getParameter("quizContent");
                        String sql = "UPDATE [dbo].[Quiz] SET [QuizName] = '" + quizName + "' ,[QuizContent] = '" + quizContent + "' WHERE QuizID = " + quizID;

                        if (quizDAO.updateQuizWithSql(sql)) {
                            out.print("success");
                        } else {
                            out.print("failed");

                        }

                        break;
                    case "updateQuestion":
                        String questionValue = request.getParameter("questionValue");
                        String answersJson = request.getParameter("answers");

                        Gson gson = new Gson();
                        Type type = new TypeToken<List<Answer>>() {
                        }.getType();
                        List<Answer> answers = gson.fromJson(answersJson, type);

                        if (quizDAO.updateQuestionInQuiz(questionID, questionValue)) {
                            if (quizDAO.updateAnswers(answers)) {
                                Question q2 = quizDAO.getQuestionById(questionID);
                                List<Answer> answers2 = q2.getAnswers();
                                String correctAnswer = "";

                                out.print("<div style=\"width: 100%; min-width: 135px\">\n"
                                        + "                                                        <h5><span>" + countQuestionUpdate + ", </span>" + q2.getQuestionContent() + "</h5>\n"
                                        + "                                                        <ul>\n"
                                        + "                                                            <li style=\"padding: 15px 0 0 0; border: none\">\n"
                                        + "                                                                <div class=\"curriculum-list-box\">\n");

                                for (int i = 0; i < answers2.size(); i++) {
                                    Answer a2 = answers2.get(i);
                                    char type2 = (char) ('A' + i);

                                    out.print("                                                                        <div style=\"display: flex; gap: 10px\">\n"
                                            + "                                                                            <h5>" + type2 + ".</h5> " + a2.getAnswerContent() + "\n"
                                            + "                                                                        </div>");

                                    if (a2.isIsCorrect()) {
                                        if (correctAnswer == "") {
                                            correctAnswer += type2;
                                        } else {
                                            correctAnswer = correctAnswer + ", " + type2;
                                        }
                                    }
                                }

                                out.print("                                                                </div>\n"
                                        + "                                                            </li>\n"
                                        + "                                                        </ul>\n"
                                        + "                                                    </div>\n"
                                        + "                                                    <h5 style=\"color: green; border-left: 1px solid lightgray; padding: 0 35px; min-width: 120px; width: 120px\">" + correctAnswer + "</h5>\n"
                                );

                                if (account.getRole().getRoleId() != 4) {
                                    out.print("                                                        <div class=\"questionCardAction\">\n"
                                            + "                                                            <i onclick=\"updateQuestionBtnClick(" + questionID + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#updateCardModal\" title=\"Update\" class=\"bi bi-pencil-fill\" style=\"color: orange; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center; border-bottom: 1px solid #cccccc\"></i>\n"
                                            + "                                                            <i onclick=\"deleteQuestionBtnClick(" + questionID + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#deleteCardModal\" title=\"Delete\" class=\"bi bi-trash3-fill\" style=\"color: red; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center\"></i>\n"
                                            + "                                                        </div>\n");
                                }

                            } else {
                                out.print("answers_failed");
                            }
                        } else {
                            out.print("question_failed");
                        }

                        break;
                    case "deleteAnswer":
                        String answerID = request.getParameter("answerID");
                        if (quizDAO.removeAnswerById(answerID)) {
                            Question q3 = quizDAO.getQuestionById(questionID);
                            List<Answer> answers3 = q3.getAnswers();
                            String correctAnswer = "";

                            out.print("<div style=\"width: 100%; min-width: 135px\">\n"
                                    + "                                                        <h5><span>" + countQuestionUpdate + ", </span>" + q3.getQuestionContent() + "</h5>\n"
                                    + "                                                        <ul>\n"
                                    + "                                                            <li style=\"padding: 15px 0 0 0; border: none\">\n"
                                    + "                                                                <div class=\"curriculum-list-box\">\n");

                            for (int i = 0; i < answers3.size(); i++) {
                                Answer a3 = answers3.get(i);
                                char type3 = (char) ('A' + i);

                                out.print("                                                                        <div style=\"display: flex; gap: 10px\">\n"
                                        + "                                                                            <h5>" + type3 + ".</h5> " + a3.getAnswerContent() + "\n"
                                        + "                                                                        </div>");

                                if (a3.isIsCorrect()) {
                                    if (correctAnswer == "") {
                                        correctAnswer += type3;
                                    } else {
                                        correctAnswer = correctAnswer + ", " + type3;
                                    }
                                }
                            }

                            out.print("                                                                </div>\n"
                                    + "                                                            </li>\n"
                                    + "                                                        </ul>\n"
                                    + "                                                    </div>\n"
                                    + "                                                    <h5 style=\"color: green; border-left: 1px solid lightgray; padding: 0 35px; min-width: 120px; width: 120px\">" + correctAnswer + "</h5>\n"
                            );

                            if (account.getRole().getRoleId() != 4) {
                                out.print("                                                        <div class=\"questionCardAction\">\n"
                                        + "                                                            <i onclick=\"updateQuestionBtnClick(" + questionID + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#updateCardModal\" title=\"Update\" class=\"bi bi-pencil-fill\" style=\"color: orange; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center; border-bottom: 1px solid #cccccc\"></i>\n"
                                        + "                                                            <i onclick=\"deleteQuestionBtnClick(" + questionID + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#deleteCardModal\" title=\"Delete\" class=\"bi bi-trash3-fill\" style=\"color: red; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center\"></i>\n"
                                        + "                                                        </div>\n");
                            }

                        } else {
                            out.print("failed");
                        }
                        break;
                    case "deleteQuestion":
                        if (quizDAO.removeQuestionInQuiz(quizID, questionID)) {
                            QuestionDAO questionDAO = new QuestionDAO();

                            List<Question> questions = questionDAO.getQuestionAndAnswersByQuizId(quizID);

                            out.print(" <div style=\"display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px\">\n"
                                    + "                                            <h4 id=\"questionLengthCount\">Question & Answers (" + questions.size() + ")</h4>\n"
                                    + "                                            <a class=\"btn radius-xl text-uppercase\" onclick=\"addQuestionBtnClick(" + subjectId + ", " + quizID + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#addQuestionModal\">Add question</a>\n"
                                    + "                                        </div>"
                                    + " <ul class=\"curriculum-list\" id=\"listQuestions\">\n");

                            for (int i = 0; i < questions.size(); i++) {
                                Question q2 = questions.get(i);
                                List<Answer> listAnswers = questions.get(i).getAnswers();
                                String correctAnswer4 = "";

                                out.print("                                                <li class=\"questionCard " + q2.getQuestionId() + "\">\n"
                                        + "                                                    <div style=\"width: 100%; min-width: 135px\">\n"
                                        + "                                                        <h5><span>" + (i + 1) + ", </span>" + q2.getQuestionContent() + "</h5>\n"
                                        + "                                                        <ul>\n"
                                        + "                                                            <li style=\"padding: 15px 0 0 0; border: none\">\n"
                                        + "                                                                <div class=\"curriculum-list-box\">\n");

                                for (int j = 0; j < listAnswers.size(); j++) {
                                    Answer a4 = listAnswers.get(j);
                                    char type4 = (char) ('A' + j);

                                    out.print("                                                                        <div style=\"display: flex; gap: 10px\">\n"
                                            + "                                                                            <h5>" + type4 + ".</h5> " + a4.getAnswerContent() + "\n"
                                            + "                                                                        </div>\n");

                                    if (a4.isIsCorrect()) {
                                        if (correctAnswer4 == "") {
                                            correctAnswer4 += type4;
                                        } else {
                                            correctAnswer4 = correctAnswer4 + ", " + type4;
                                        }
                                    }
                                }

                                out.print("                                                                </div>\n"
                                        + "                                                            </li>\n"
                                        + "                                                        </ul>\n"
                                        + "                                                    </div>\n"
                                        + "                                                    <h5 style=\"color: green; border-left: 1px solid lightgray; padding: 0 35px; min-width: 120px; width: 120px\">" + correctAnswer4 + "</h5>\n");

                                if (account.getRole().getRoleId() != 4) {
                                    out.print("                                                        <div class=\"questionCardAction\">\n"
                                            + "                                                            <i onclick=\"updateQuestionBtnClick(" + q2.getQuestionId() + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#updateCardModal\" title=\"Update\" class=\"bi bi-pencil-fill\" style=\"color: orange; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center; border-bottom: 1px solid #cccccc\"></i>\n"
                                            + "                                                            <i onclick=\"deleteQuestionBtnClick(" + q2.getQuestionId() + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#deleteCardModal\" title=\"Delete\" class=\"bi bi-trash3-fill\" style=\"color: red; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center\"></i>\n"
                                            + "                                                        </div>\n");
                                }

                                out.print("                                                </li>\n");
                            }

                            out.print("                                        </ul>");

                        } else {
                            out.print("failed");
                        }
                        break;

                    case "getQuestionsBySubject":
                        QuestionDAO questionDAO = new QuestionDAO();

                        List<Question> questions = questionDAO.getQuestionAndAnswersBySubjectId(quizID, subjectId);

                        if (questions != null) {
                            for (Question q5 : questions) {
                                out.print("<div class='question-group " + q5.getQuestionId() + "' style=\"display: flex; gap: 15px; margin-bottom: 15px; padding: 10px 14px; box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px; height: fit-content; border-radius: 20px\">\n"
                                        + "                                <div class=\"question\">" + q5.getQuestionContent() + "</div>\n"
                                        + "                                <i class=\"bi bi-plus-circle-fill addQuestionToListBtn\" onclick='addToQuestionList(" + q5.getQuestionId() + ")' style=\"color: green; margin-top: 2px; font-size: 25px; cursor: pointer\"></i>\n"
                                        + "                            </div>");
                            }

                        } else if (questions.size() == 0) {
                            out.print("empty");
                        } else {
                            out.print("failed");
                        }

                        break;

                    case "addToQuestionList":
                        if (quizDAO.addQuizQuestion(quizID, questionID)) {
                            Question q6 = quizDAO.getQuestionById(questionID);
                            List<Answer> answers6 = q6.getAnswers();
                            String questionsLength = request.getParameter("questionsLength");
                            String correctAnswer6 = "";

                            out.print("<li class=\"questionCard " + questionID + "\">"
                                    + "<div style=\"width: 100%; min-width: 135px\">\n"
                                    + "                                                        <h5><span>" + questionsLength + ", </span>" + q6.getQuestionContent() + "</h5>\n"
                                    + "                                                        <ul>\n"
                                    + "                                                            <li style=\"padding: 15px 0 0 0; border: none\">\n"
                                    + "                                                                <div class=\"curriculum-list-box\">\n");

                            for (int i = 0; i < answers6.size(); i++) {
                                Answer a6 = answers6.get(i);
                                char type6 = (char) ('A' + i);

                                out.print("                                                                        <div style=\"display: flex; gap: 10px\">\n"
                                        + "                                                                            <h5>" + type6 + ".</h5> " + a6.getAnswerContent() + "\n"
                                        + "                                                                        </div>");

                                if (a6.isIsCorrect()) {
                                    if (correctAnswer6 == "") {
                                        correctAnswer6 += type6;
                                    } else {
                                        correctAnswer6 = correctAnswer6 + ", " + type6;
                                    }
                                }
                            }

                            out.print("                                                                </div>\n"
                                    + "                                                            </li>\n"
                                    + "                                                        </ul>\n"
                                    + "                                                    </div>\n"
                                    + "                                                    <h5 style=\"color: green; border-left: 1px solid lightgray; padding: 0 35px; min-width: 120px; width: 120px\">" + correctAnswer6 + "</h5>\n"
                            );

                            if (account.getRole().getRoleId() != 4) {
                                out.print("                                                        <div class=\"questionCardAction\">\n"
                                        + "                                                            <i onclick=\"updateQuestionBtnClick(" + questionID + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#updateCardModal\" title=\"Update\" class=\"bi bi-pencil-fill\" style=\"color: orange; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center; border-bottom: 1px solid #cccccc\"></i>\n"
                                        + "                                                            <i onclick=\"deleteQuestionBtnClick(" + questionID + ", " + quizID + "," + subjectId + ")\" data-bs-toggle=\"modal\" data-bs-target=\"#deleteCardModal\" title=\"Delete\" class=\"bi bi-trash3-fill\" style=\"color: red; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center\"></i>\n"
                                        + "                                                        </div>\n");
                            }

                            out.print("</li>");
                        } else {
                            out.print("failed");
                        }
                        break;

                    default:
                        throw new AssertionError();
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
