/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.AccountDAO;
import Models.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;

/**
 *
 * @author owner
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                } else if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }

        if (username.isEmpty() && password.isEmpty()) {
            request.setAttribute("remember", false);
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("remember", true);
        }

        request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
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
        //lấy thông tin từ form
        String UserName = request.getParameter("username");
        String Password = request.getParameter("password");
        String Remember = request.getParameter("remember");

        AccountDAO adb = new AccountDAO();
        Account account = adb.getAccount(UserName, Password);

        if (account == null) {
            request.setAttribute("username", UserName);
            request.setAttribute("password", Password);

            request.setAttribute("messColor", "red");
            request.setAttribute("mess", "Username or password not correct. Please try again!");

            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);

        } else if (!account.getStatus()) {
            request.setAttribute("username", UserName);
            request.setAttribute("password", Password);

            request.setAttribute("messColor", "red");
            request.setAttribute("mess", "Your account is inactive. Please contact Admin!");

            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);

        } else {
            //save thông tin đăng nhập vào cookies nếu người dùng chọn "Remember"
            if (Remember != null) {

                Cookie usernameCookie = new Cookie("username", UserName);
                Cookie passwordCookie = new Cookie("password", Password);

                //đặt thời gian cho cookies là 30 ngày
                int cookieMaxAge = 30 * 24 * 60 * 60;
                usernameCookie.setMaxAge(cookieMaxAge);
                passwordCookie.setMaxAge(cookieMaxAge);

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            } else {
                //user không chọn "Remember", hủy cookies nếu có
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("username") || cookie.getName().equals("password")) {
                            cookie.setMaxAge(0); //hủy cookie
                            response.addCookie(cookie);
                        }
                    }
                }
            }

            HttpSession session = request.getSession();
            session.setAttribute("account", account);

            response.sendRedirect("/SWP391_SE1749_NET_GROUP2");
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
