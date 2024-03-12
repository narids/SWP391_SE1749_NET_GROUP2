/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Common;

import DAOs.SubjectDAO;
import DAOs.SubjectDeDAO;
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
@WebServlet(name = "AddSubjectController", urlPatterns = {"/addsubject"})

public class AddSubjectController extends HttpServlet {

    SubjectDAO queD = new SubjectDAO();
    SubjectDeDAO subD = new SubjectDeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("subjectdeid"));
        SubjectDimension subdi = subD.getbyIDfull(id);
        request.setAttribute("subjectdimension", subdi);
        request.getRequestDispatcher("jsp/addsubject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("addsubjectname");
        String explain = request.getParameter("addsubjectdetail");
        String id = request.getParameter("subjectdiid");
        queD.addSubject(explain, explain, id);
        response.sendRedirect("subjectlist?subjectdeid=" + id);
    }
}
