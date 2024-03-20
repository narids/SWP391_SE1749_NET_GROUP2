/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.SubjectDeDAO;
import Models.Account;
import Models.SubjectDimension;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "SubDimensionDetailController", urlPatterns = {"/subdidetail"})

public class SubDimensionDetailController extends HttpServlet {

    SubjectDeDAO subde = new SubjectDeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");
        } else {
            if (account.getRole().getRoleId() == 3 || account.getRole().getRoleId() == 2) {
                int id = Integer.parseInt(request.getParameter("subjectdeid"));
                SubjectDimension subd = subde.getbyID(id);
                request.setAttribute("subdedetail", subd);
                request.getRequestDispatcher("jsp/subdedetail.jsp").forward(request, response);
            } else{
                response.sendRedirect("home");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("subdiname");
        String explain = request.getParameter("subdidetail");
        int id = Integer.parseInt(request.getParameter("subjectdeid"));
        subde.updateDi(content, explain, id);
        response.sendRedirect("subdelist");
    }

}
