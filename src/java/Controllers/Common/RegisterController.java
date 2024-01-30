/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import Ultils.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.mail.MessagingException;

/**
 *
 * @author owner
 */
public class RegisterController extends HttpServlet {

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
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        AccountDAO accDAO = new AccountDAO();
        
        //kiểm tra tham số action có tồn tại không
        if (action != null) {
            switch (action) {
                case "register":
                    String emailInput = request.getParameter("email").trim();
                    String usernameInput = request.getParameter("username").trim();
                    String passwordInput = request.getParameter("password").trim();
                    
                    //kiểm tra tên người dùng hoặc email tồn tại chưa
                    if (accDAO.checkExistedUser(usernameInput) || accDAO.checkExistedEmail(emailInput)) {
                        try (PrintWriter out = response.getWriter()) {
                            out.print("existed");
                        }
                    } else {
                        try {
                            String vecode = String.valueOf((int) ((Math.random() * (999999 - 100000)) + 100000));
                            long currentTime = System.currentTimeMillis();
                            
                            SendEmail.sendEmail(emailInput, vecode);
                            
                            session.setAttribute("email", emailInput);
                            session.setAttribute("username", usernameInput);
                            session.setAttribute("password", passwordInput);
                            session.setAttribute("vecode", vecode);
                            session.setAttribute("verificationTime", currentTime);
                            
                            try (PrintWriter out = response.getWriter()) {
                                out.print("success");
                            }
                        } catch (MessagingException ex) {
                            try (PrintWriter out = response.getWriter()) {
                                out.print("sendEmailFailed");
                            }
                        }
                        
                    }
                    
                    break;
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
