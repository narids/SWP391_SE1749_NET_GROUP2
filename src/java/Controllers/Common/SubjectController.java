/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.SubjectDAO;
import DAOs.SubjectDeDAO;
import Models.Account;
import Models.Subject;
import Models.SubjectDimension;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "SubjectController", urlPatterns = {"/subjectlist"})

public class SubjectController extends HttpServlet{
        SubjectDAO queD = new SubjectDAO();
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("subjectdeid");
        List<Subject> lst = queD.getlist(id);
        request.setAttribute("subdiid", id);
        request.setAttribute("sublistbyid", lst);
        request.getRequestDispatcher("jsp/subjectList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("subaction");
        switch (action) {
            case "delete":
                int id = Integer.parseInt(request.getParameter("subjectId"));
                String deid = String.valueOf(queD.getIDbyID(id));
                queD.deleteClassSubject(id);
                queD.deleteByID(id);
                response.sendRedirect("subjectlist?subjectdeid="+deid);
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
