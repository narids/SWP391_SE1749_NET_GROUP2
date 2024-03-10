/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.QuestionDAO;
import DAOs.SubjectDAO;
import Models.Question;
import Models.Subject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        SubjectDAO subD = new SubjectDAO();
        List<Subject> lst = subD.list();
        request.setAttribute("sublist", lst);
        request.getRequestDispatcher("jsp/addques.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve form data
        String content = request.getParameter("content");
        String explain = request.getParameter("explain");
        String[] options = request.getParameterValues("option");
        String[] correctAnswers = request.getParameterValues("correct");

        // Database connection parameters
        String url = "jdbc:sqlserver://LAPTEO\\SQLEXPRESS:1433;databaseName=Group2_SWP319_SE1749";
        String user = "hung";
        String pass = "1234";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Establish connection
            Connection con = DriverManager.getConnection(url, user, pass);

            // Create SQL statement
            PreparedStatement pstmt = con.prepareStatement("insert into Question (Question_Content,Created_Day,Explain) \n"
                    + "values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, content);
            pstmt.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            pstmt.setString(3, explain);
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int questionId = generatedKeys.getInt(1);
                // Insert options into the database
                for (int i = 0; i < options.length; i++) {
                    String optionText = options[i];
                    boolean isCorrect = (correctAnswers != null && correctAnswers.length > 0 && correctAnswers[i].equals(String.valueOf(i + 1)));
                    PreparedStatement optionStmt = con.prepareStatement("INSERT INTO Answer (QuestionID, Answer_Content,IsCorrect) VALUES (?, ?,?)");
                    optionStmt.setInt(1, questionId);
                    optionStmt.setString(2, optionText);
                    optionStmt.setBoolean(3, isCorrect);
                    optionStmt.executeUpdate();
                    optionStmt.close();

                }
            }
            pstmt.close();
            con.close();

            out.println("<h3>Question added successfully!</h3>");
            out.println("<a href='add_question.html'>Add Another Question</a>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
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
