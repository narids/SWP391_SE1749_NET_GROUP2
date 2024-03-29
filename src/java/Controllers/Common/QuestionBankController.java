/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.AnswerDAO;
import DAOs.QuestionDAO;
import Models.Account;
import Models.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
@WebServlet(name = "QuestionBankController", urlPatterns = {"/questionbank"})

public class QuestionBankController extends HttpServlet {

    QuestionDAO queD = new QuestionDAO();
   AnswerDAO anD = new AnswerDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");
        } else {
            if (account.getRole().getRoleId() == 3 || account.getRole().getRoleId() == 2) {
                List<Question> lst = queD.list();
                request.setAttribute("queslist", lst);
                request.getRequestDispatcher("jsp/questionbank.jsp").forward(request, response);
            } else {
                response.sendRedirect("home");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("quesaction");
        switch (action) {
            case "delete":
                String ID = request.getParameter("questionid");
                int id = Integer.parseInt(request.getParameter("questionid"));
                anD.deleteByID(id);
                queD.deleteByID(ID);
                response.sendRedirect("questionbank");
                break;
            default:
                throw new AssertionError();
        }
    }

}
