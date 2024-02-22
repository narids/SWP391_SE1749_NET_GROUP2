/*+
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Manager;

import DAOs.ClassDAO;
import Models.MyClass;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author nghia
 */
public class ClassDetailController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClassDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassDetailController at " + request.getContextPath() + "</h1>");
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
        ClassDAO t = new ClassDAO();
        int ClassID = Integer.parseInt(request.getParameter("id"));
        
        String TeacherID= t.getTeacherByClassID(ClassID);
        request.setAttribute("TeacherID", TeacherID);
        
        List<String> TeacherIDs = t.getTeacherIDs(); 
        request.setAttribute("TeacherIDs", TeacherIDs);
        
        MyClass ClassSelected = t.getClassesByID(ClassID);
        request.setAttribute("classSelected", ClassSelected);
//        int numStudent = t.getNumberOfStudentInClass(ClassID);
//        request.setAttribute("num", numStudent);
      
        request.getRequestDispatcher("jsp/ClassDetail.jsp").forward(request, response);
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
     
        ClassDAO t = new ClassDAO(); 
        int ClassId = Integer.parseInt(request.getParameter("ClassId")); 
        String TeacherID =request.getParameter("TeacherID"); 
        t.updateClasses(TeacherID, ClassId);
        response.sendRedirect("class");

        
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
