/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.QuestionDAO;
import DAOs.SubjectDAO;
import Models.Account;
import Models.Question;
import Models.Subject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
@WebServlet(name = "AddQuestionController", urlPatterns = {"/addques"})

public class AddQuestionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");

        } else {
        SubjectDAO subD = new SubjectDAO();
        List<Subject> lst = subD.list();
        request.setAttribute("sublist", lst);
        request.getRequestDispatcher("jsp/addques.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve form data
        String content = request.getParameter("quescontent");
        String explain = request.getParameter("quesexplain");
        String subject = request.getParameter("subject");
        String[] options = request.getParameterValues("option[]");
        String[] correctAnswers = request.getParameterValues("correct[]");

        String url = "jdbc:sqlserver://LAPTEO\\SQLEXPRESS:1433;databaseName=Group2_SWP319_SE1749";
        String user = "hung";
        String pass = "1234";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(url, user, pass);

            // SQL query to insert question
            String sqlQuery = "insert into Question (Question_Content,Created_Day,ImageURL,Explain,SubjectId) \n"
                    + "values (?,?,?,?,?)";

            // Create a PreparedStatement object
            statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, content);
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            statement.setString(3, explain);
            statement.setString(4, explain);
            SubjectDAO sub = new SubjectDAO();
            int subid = sub.getIDbyName(subject);
            statement.setInt(5, subid);

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
                        String insertOptionQuery = "INSERT INTO Answer (Answer_Content, IsCorrect,QuestionID) VALUES (?, ?,?)";
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

    private String getSubmittedFileName(Part part) {
        if (part != null) {
            for (String cd : part.getHeader("content-disposition").split(";")) {
                if (cd.trim().startsWith("filename")) {
                    String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                    return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
                }
            }
        }
        return null; // Return null if part is null or file name is not found
    }
}
