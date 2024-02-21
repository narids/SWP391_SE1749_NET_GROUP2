/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Common;

import DAOs.NewsDAO;
import Models.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author admin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(name = "AddNewsController", urlPatterns = {"/add-news"})
public class AddNewsController extends HttpServlet {

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
        request.getRequestDispatcher("jsp/add-news.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String content = request.getParameter("content");

// Get the uploaded file
        Part filePart = request.getPart("thumbnail");
        String fileName = getSubmittedFileName(filePart); // Get the file name

// Specify the directory to save the file
        String uploadPath = getServletContext().getRealPath("assets") + File.separator + "news-thumbnail";
        File folder = new File(uploadPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

// Construct the file path where the uploaded file will be saved
        String filePath = uploadPath + File.separator + fileName;

// Save the uploaded file to the specified file path
        filePart.write(filePath);

        if(account != null) {
//            userId = account.getRoleId();
        }
        ndao.addNews(title, summary, content, filePath, userId, 0);
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
