/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.NewsDAO;
import Models.Account;
import Models.News;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;

/**
 *
 * @author win
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
@WebServlet(name = "NewsDetailController", urlPatterns = {"/news-detail"})
public class NewsDetailController extends HttpServlet {

    NewsDAO ndao = new NewsDAO();

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
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        News news = ndao.getNewsById(newsId);
        request.setAttribute("news", news);
        request.getRequestDispatcher("jsp/news-detail.jsp").forward(request, response);
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
        int userId = 1;
        Account account = (Account) request.getSession().getAttribute("account");
        if (account != null) {
//            userId = account.getRoleId();
        }
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String content = request.getParameter("content");
        int status = Integer.parseInt(request.getParameter("rbStatus"));

        // Handle file upload
        Part filePart = request.getPart("thumbnail");
        String fileName = getSubmittedFileName(filePart);
        System.out.println(fileName);
        if (fileName.length() > 0) {
            String uploadPath = getServletContext().getRealPath("assets") + File.separator + "news-thumbnail";
            // Save the file to the specified directory
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            ndao.updateNews(title, summary, content, filePath, userId, 1, newsId);
        } else {
            ndao.updateNews(title, summary, content, userId, 1, newsId);
        }
        response.sendRedirect("news-list");

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
    // Helper method to extract file name from Part

    private String getSubmittedFileName(Part part) {
        if (part != null) {
            for (String cd : part.getHeader("content-disposition").split(";")) {
                if (cd.trim().startsWith("filename")) {
                    String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                    return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
                }
            }
        }
        return null; // Return null if part is null or file name is not found
    }

}
