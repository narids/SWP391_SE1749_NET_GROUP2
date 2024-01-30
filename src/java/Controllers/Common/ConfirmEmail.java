/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import Models.Account;
import Models.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author owner
 */
public class ConfirmEmail extends HttpServlet {

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
            out.println("<title>Servlet ConfirmEmail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmEmail at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("jsp/confirmEmail.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        AccountDAO accDAO = new AccountDAO();
        
        String action = request.getParameter("action");
        // switch case check action

        String codeInput = request.getParameter("code").trim();
        String vefcode = (String) session.getAttribute("vecode");
        

        try {
            long afverificationTime = (long) session.getAttribute("verificationTime");

            if (codeInput.equals(vefcode)) {
                long currentTimes = System.currentTimeMillis();
                long elapsedTime = TimeUnit.MILLISECONDS.toSeconds(currentTimes - afverificationTime);

                if (elapsedTime <= 60) {
                    // => active account : email + code
                    // resend code
                    Account acc = new Account();
                    Role role = new Role();

                    acc.setUsername((String) session.getAttribute("username"));
                    acc.setEmail((String) session.getAttribute("email"));
                    acc.setPassword((String) session.getAttribute("password"));
                    acc.setAvatar("");
                    acc.setStatus(true);

                    role.setRoleId(4); // student
                    acc.setRole(role);

                    if (accDAO.registerUser(acc)) {
                        try (PrintWriter out = response.getWriter()) {
                            out.print("success");
                        }
                    } else {
                        try (PrintWriter out = response.getWriter()) {
                            out.print("failed");
                        }
                    }

                } else {
                    try (PrintWriter out = response.getWriter()) {
                        out.print("timeout");
                    }
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.print("invalid");
                }
            }
        } catch (Exception e) {
            try (PrintWriter out = response.getWriter()) {
                out.print("timeout");
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
