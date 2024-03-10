/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Admin;

import DAOs.AccountDAO;
import Models.Account;
import Models.Role;
import Ultils.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author win
 */
@WebServlet(name = "UserListController", urlPatterns = {"/user-list"})
public class UserListController extends HttpServlet {

    AccountDAO adao = new AccountDAO();

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
        String action = request.getParameter("action");
        request.setAttribute("roles", adao.getRoleList());
        switch (action) {
            case "view":
                request.setAttribute("accounts", adao.getAccountList());
                request.getRequestDispatcher("jsp/user-list.jsp").forward(request, response);
                break;
            case "detail":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("account", adao.getAccountById(id));
                request.getRequestDispatcher("jsp/user-detail.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
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
        String msg = "failed";
        switch (action) {
            case "detail":
                adao.updateAccount(
                        Integer.parseInt(request.getParameter("id")),
                        request.getParameter("username"),
                        request.getParameter("fullname"),
                        request.getParameter("email"),
                        Integer.parseInt(request.getParameter("role")),
                        request.getParameter("status").contains("1") ? true : false);
//                    response.sendRedirect("user-list?action=view");
                msg = "success";
                request.getSession().setAttribute("isUpdateSuccess", true);
                break;
            case "insert":
                if (!adao.checkExistedEmailOrUser(request.getParameter("email"), request.getParameter("username"))) {
                    String password = adao.generateRandomPassword(8);
                    int aid = adao.insertAccount(
                            request.getParameter("username"),
                            request.getParameter("fullname"),
                            request.getParameter("email"),
                            Integer.parseInt(request.getParameter("role")),
                            request.getParameter("status").contains("1") ? true : false,
                            password);
                    try {
                        SendEmail.sendEmailPassword(request.getParameter("email"), request.getParameter("username"), password);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (Integer.parseInt(request.getParameter("role")) == 4) {
                        adao.addToStudentAccounts(aid);
                    } else if (Integer.parseInt(request.getParameter("role")) == 3) {
                        adao.addToTeacherAccounts(aid);
                    }
                    msg = "success";
                    request.getSession().setAttribute("isAddSuccess", true);
                }
                break;
            default:
                throw new AssertionError();
        }
        try ( PrintWriter out = response.getWriter()) {
            out.print(msg);
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
