/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Teacher;

import DAOs.ClassDAO;
import DAOs.StudentDAO;
import Models.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author nghia
 */
public class StudentListController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

//            StudentDAO s = new StudentDAO();
//            int ClassID = Integer.parseInt(request.getParameter("Classid"));
//            List<Student> StudentList = s.getStudentIdByClassID(ClassID);
//            request.setAttribute("StudentList", StudentList);
//            request.getRequestDispatcher("jsp/Student-list.jsp").forward(request, response);
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
        StudentDAO s = new StudentDAO();
//        int ClassID = Integer.parseInt(request.getParameter("Classid"));
        HttpSession session = request.getSession();
        int ClassID = (int) session.getAttribute("Classid");
        List<Student> StudentList = s.getStudentIdByClassID(ClassID);
        request.setAttribute("StudentList", StudentList);
        request.getRequestDispatcher("jsp/Student-list.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        if (action != null) {
            StudentDAO s = new StudentDAO();
            switch (action) {
                case "delete":
                    HttpSession session = request.getSession();
                    int ClassID = (int) session.getAttribute("Classid");
                    int id = Integer.parseInt(request.getParameter("StudentID"));
                    s.removeStudentFromClassByStudentID(id, ClassID);
                    response.sendRedirect("StudentList");
                    break;
                default:
                    throw new AssertionError();
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
