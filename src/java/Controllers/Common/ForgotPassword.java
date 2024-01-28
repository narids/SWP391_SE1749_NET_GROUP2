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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author owner
 */
public class ForgotPassword extends HttpServlet {

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
            out.println("<title>Servlet ForgotPassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPassword at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("jsp/forgot-password.jsp").forward(request, response);
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

        if (action != null) {
            switch (action) {
                case "verifyforgot":
                    String vem = request.getParameter("email");

                    if (!accDAO.checkExistedEmail(vem)) {
                        session.setAttribute("email", vem);
                        request.setAttribute("mess", "Email not existed, please register.");
                        request.setAttribute("messColor", "red");
                        request.getRequestDispatcher("jsp/forgot-password.jsp").forward(request, response);

                    } else {
                        String vecode = String.valueOf((int) ((Math.random() * (999999 - 100000)) + 100000));
                        long currentTime = System.currentTimeMillis();

                        try {
                            SendEmail.sendEmail(vem, vecode);

                            session.setAttribute("email", vem);
                            session.setAttribute("vecode", vecode);
                            session.setAttribute("verificationTime", currentTime);
                            request.getRequestDispatcher("jsp/verifyforgot.jsp").forward(request, response);

                        } catch (MessagingException ex) {
                            session.setAttribute("email", vem);
                            request.setAttribute("mess", "Send email failed.");
                            request.setAttribute("messColor", "red");
                            request.getRequestDispatcher("jsp/forgot-password.jsp").forward(request, response);
                        }
                    }

                    break;
                case "fverify":
                    String fcode = request.getParameter("code");
                    String vefcode = (String) session.getAttribute("vecode");

                    try {
                        long afverificationTime = (long) session.getAttribute("verificationTime");

                        if (fcode.equals(vefcode)) {

                            // Check if the verification code is still valid (within 60 seconds)
                            long currentTimes = System.currentTimeMillis();
                            long elapsedTime = TimeUnit.MILLISECONDS.toSeconds(currentTimes - afverificationTime);

                            if (elapsedTime <= 60) {
                                request.setAttribute("mess", "Verification correct code, let change password");
                                request.setAttribute("messColor", "green");
                                request.getRequestDispatcher("jsp/resetpass.jsp").forward(request, response);
                            } else {
                                request.setAttribute("codeInput", fcode);
                                request.setAttribute("mess", "Verification code has expired.");
                                request.setAttribute("messColor", "red");
                                request.getRequestDispatcher("jsp/verifyforgot.jsp").forward(request, response);
                            }
                        } else {
                            request.setAttribute("codeInput", fcode);

                            request.setAttribute("mess", "Invalid verification code.");
                            request.setAttribute("messColor", "red");
                            request.getRequestDispatcher("jsp/verifyforgot.jsp").forward(request, response);
                        }
                    } catch (Exception e) {
                        request.setAttribute("mess", "Verification code has expired.");
                        request.setAttribute("messColor", "red");
                        request.getRequestDispatcher("jsp/verifyforgot.jsp").forward(request, response);
                    }

                    break;
                case "changepassword":
                    String cmail = (String) session.getAttribute("email");
                    String cpass = request.getParameter("password");

                    if (!cmail.equals("null")) {
                        accDAO.resetPass(cpass, cmail);
                        
                        try (PrintWriter out = response.getWriter()) {
                            out.print("success");
                        }

                    } else {
                        try (PrintWriter out = response.getWriter()) {
                            out.print("failed");
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
