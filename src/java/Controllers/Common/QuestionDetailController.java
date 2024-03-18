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

/**
 *
 * @author User
 */
@WebServlet(name = "QuestionDetailController", urlPatterns = {"/questiondetail"})

public class QuestionDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
        AnswerDAO an = new AnswerDAO();
        SubjectDAO subD = new SubjectDAO();
        List<Subject> lst = subD.list();
        request.setAttribute("sublistt", lst);
        String id = request.getParameter("questionid");
        QuestionDAO qued = new QuestionDAO();
        Question que = qued.getbyId(id);
        request.setAttribute("questiondetail", que);
        List<Answer> list = an.getAnswerByQuestion(Integer.parseInt(id));
                request.setAttribute("listan", list);
        request.getRequestDispatcher("jsp/questiondetail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("questionid");
        
        String content = request.getParameter("quescontentdetail");
        String explain = request.getParameter("quesexplaindetail");
        String subject = request.getParameter("subjectdetail");
        String[] options = request.getParameterValues("options[]");
        String[] correctAnswers = request.getParameterValues("corrects[]");

        String url = "jdbc:sqlserver://LAPTEO\\SQLEXPRESS:1433;databaseName=Group2_SWP319_SE1749";
        String user = "hung";
        String pass = "1234";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(url, user, pass);

            // SQL query to insert question
            String sqlQuery = "UPDATE [dbo].[Question] "
                    + "SET [Question_Content] = ?,"
                    + "[Created_Day] = ?,"
                    + "[ImageURL] = ?,"
                    + "[Explain] = ? ,"
                    + "SubjectId=?"
                    + "WHERE [QuestionID] = ?";

            // Create a PreparedStatement object
            statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, content);
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            statement.setString(3, explain);
            statement.setString(4, explain);
            SubjectDAO sub = new SubjectDAO();
            int subid = sub.getIDbyName(subject);
            statement.setInt(5, subid);
            statement.setString(6, id);

            // Execute the query
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating question failed, no rows affected.");
            }

            // Get the auto-generated question ID
            try ( ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int questionId = generatedKeys.getInt(1);

                    // Insert options into the database
                    for (int i = 0; i < options.length; i++) {
                        String optionText = options[i];
                        boolean isCorrect = (correctAnswers != null && correctAnswers.length > 0 && correctAnswers[i].equals(String.valueOf(i + 1)));
                        // SQL query to insert option
                        String insertOptionQuery = "UPDATE [dbo].[Question] "
                                + "SET [Answer_Content] = ?,"
                                + "[IsCorrect] = ?,"
                                + "WHERE [QuestionID] = ?";

                        statement = connection.prepareStatement(insertOptionQuery);
                        statement.setString(1, optionText);
                        statement.setBoolean(2, isCorrect);
                        statement.setInt(3, questionId);
                        statement.executeUpdate();
                    }
                } else {
                    throw new SQLException("Creating question failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close connections
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        response.sendRedirect("questionbank");
    }
}
