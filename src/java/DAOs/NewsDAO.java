/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.News;
import Models.NewsComment;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class NewsDAO extends DBContext<BaseEntity> {

    @Override
    public ArrayList<BaseEntity> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BaseEntity get(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public News getNews(String email, String pass) {
//        String strSQL = "SELECT [UserId]\n"
//                + "      ,[FullName]\n"
//                + "      ,[Password]\n"
//                + "      ,[Email]\n"
//                + "      ,[BirthDate]\n"
//                + "      ,[Address]\n"
//                + "      ,[Gender]\n"
//                + "      ,[Role]\n"
//                + "  FROM [PRJ301_SE1758_FA23].[dbo].[Users_HE140553]"
//                + "where Email = ? and Password=?";
//        User u = null;
//        try {
//            PreparedStatement statement = connection.prepareStatement(strSQL);
//            ResultSet resultSet=null;
//
//            statement.setString(1, email);
//            statement.setString(2, pass);
//            resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                u = new User();
//                u.setUserId(resultSet.getString(1));
//                u.setFullName(resultSet.getString(2));
//                u.setPassword(resultSet.getString(3));
//                u.setEmail(resultSet.getString(4));
//                u.setBirthDate(resultSet.getString(5));
//                u.setAddress(resultSet.getString(6));
//                u.setGender(resultSet.getString(7));
//                u.setRole(resultSet.getString(8));
//                
//            }
//        } catch (Exception e) {
//            System.out.println("getUser" + e.getMessage());
//        }
//        return u;
//    }
//    public User checkAccountExist(String email) {
//        String strSQL = "select UserId, Email, Password  from Users_HE140553 where Email = ?";
//        try {
//            PreparedStatement statement = null;
//            statement = connection.prepareStatement(strSQL);
//            statement.setString(1, email);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                String id = resultSet.getString(1);
//                String mail = resultSet.getString(2);
//                String pass = resultSet.getString(3);
//                return new User(id, mail, pass);
//            }
//        } catch (Exception e) {
//            System.out.println("getUser" + e.getMessage());
//        }
//        return null;
//    }
//    public void signup(String email, String pass, String fullName) {
//        String query = "INSERT INTO [dbo].[Users_HE140553]\n"
//                + "           ([FullName]\n"
//                + "           ,[Password]\n"
//                + "           ,[Email]\n"
//                + "           ,[Role])\n"
//                + "     VALUES\n"
//                + "           (?,?,?,1)";    
//        try {
//            PreparedStatement statement = connection.prepareStatement(query);          
//            statement.setString(1, fullName);
//            statement.setString(2, pass);
//            statement.setString(3, email);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("Error: "  + e.getMessage());
//        }
//    }
//    public void addUser(String fullName, String email, String password
//                        , String address, String gender, String birthDate) {
//        try {
//            String query = "INSERT INTO [dbo].[Users_HE140553]\n"
//                    + "           ([FullName]\n"
//                    + "           ,[Password]\n"
//                    + "           ,[Email]\n"
//                    + "           ,[BirthDate]\n"
//                    + "           ,[Address]\n"
//                    + "           ,[Gender]\n"
//                    + "           ,[Role])\n"
//                    + "     VALUES (?,?,?,?,?,?,1)";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, fullName);
//            statement.setString(2, password);
//            statement.setString(3, email);
//            statement.setString(4, birthDate);
//            statement.setString(5, address);
//            statement.setString(6, gender);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("addReview: " + e.getMessage());
//        }
//    }
//    public void updateUser(String fullName, String email,String address, String gender, String birthDate, String userId) {
//        try {
//            String query = "UPDATE [dbo].[Users_HE140553]\n"
//                    + "   SET [FullName] = ?\n"
//                    + "      ,[Email] = ?\n"
//                    + "      ,[BirthDate] = ?\n"
//                    + "      ,[Address] = ?\n"
//                    + "      ,[Gender] = ?\n"
//                    + " WHERE [UserId] = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, fullName);
//            statement.setString(2, email);
//            statement.setString(3, birthDate);
//            statement.setString(4, address);
//            statement.setString(5, gender);
//            statement.setString(6, userId);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("addReview: " + e.getMessage());
//        }
//    }
//    public void changePassword(String email, String password){
//        try {
//            String query = "UPDATE [dbo].[Users_HE140553]\n"
//                    + "   SET [Password] = ?  \n"
//                    + " WHERE [Email] = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, password);
//            statement.setString(2, email);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("addReview: " + e.getMessage());
//        }
//    }
//    public boolean deleteUser(int userId) {
//        
//        String query = "DELETE FROM [dbo].[Users_HE140553]\n" 
//                +   "      WHERE [UserId] = ?";
//        
//        try {
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, userId);
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return false;
//    }
    public ArrayList<News> getListNew() {
        ArrayList<News> newList = new ArrayList<News>();

        try {
            String strSQL = "select * from News";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                News news = new News();
                int NewsID = resultSet.getInt(1);
                String Title = resultSet.getString(2);
                String Content = resultSet.getString(3);
                Date Created_Day = resultSet.getDate(4);
//                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
//                String birthDate = "";
//                if (resultSet.getDate(5) != null) {
//                    birthDate = f.format(resultSet.getDate(5));
//                }
                String Thumbnail = resultSet.getString(5);
                news.setNewsId(NewsID);
                news.setTitle(Title);
                news.setContent(Content);
                news.setCreatedDay(Created_Day);
                news.setThumbnail(Thumbnail);
                news.setSummary(resultSet.getString("Summary"));
                news.setNumberCommment(resultSet.getInt("NumberComment"));
                news.setCreatedBy(resultSet.getInt("Created_By"));
                news.setViewsCount(resultSet.getInt("ViewsCount"));
                news.setStatus(resultSet.getInt("Status"));
//                News n = new News(NewsID, Title, Content, Created_Day, Thumbnail);
//                newList.add(n);
                newList.add(news);
            }
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
        return newList;
    }

    public String getFullnameById(int id) {
        try {
            String strSQL = "select Fullname from Account WHERE UserID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("Fullname");
            }
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
        return null;
    }

    public void addNews(String title, String summary, String content, String thumbnail, int userId, int status) {

        try {
            String strSQL = "INSERT INTO [dbo].[News]"
                    + "([Title],[Content],[Created_Day],"
                    + "[Thumbnail],[Summary],[NumberComment],"
                    + "[Created_By],[ViewsCount],[Status]) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            statement.setString(4, thumbnail);
            statement.setString(5, summary);
            statement.setInt(6, 0);
            statement.setInt(7, userId);
            statement.setInt(8, 0);
            statement.setInt(9, status);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void addComment(String content, int userId, int newsId, int ParentId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(new Date());
        try {
            String strSQL = "INSERT INTO [NewsComment]"
                    + "([Content],[Created_Day],"
                    + "[Created_By],[ParentID],[NewsID]) "
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setString(1, content);
            statement.setDate(2, java.sql.Date.valueOf(formattedDate));
            statement.setInt(3, userId);
            statement.setInt(4, ParentId);
            statement.setInt(5, newsId);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteNews(int id) {
        try {
            String strSQL = "DELETE FROM [dbo].[News] WHERE NewsID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteCommentByParentID(int ParentID) {
        try {
            String strSQL = "DELETE FROM [NewsComment] WHERE ParentID = ?";

            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, ParentID);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteCommentByCommentID(int CommentID) {
        try {
            String strSQL = "DELETE FROM [NewsComment] WHERE CommentID = ?";

            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, CommentID);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public News getNewsById(int id) {
        String sql = "SELECT * FROM News WHERE NewsID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsId(rs.getInt("NewsID"));
                news.setTitle(rs.getString("Title"));
                news.setContent(rs.getString("Content"));
                news.setCreatedDay(rs.getDate("Created_Day"));
                news.setThumbnail(rs.getString("Thumbnail"));
                news.setSummary(rs.getString("Summary"));
                news.setNumberCommment(rs.getInt("NumberComment"));
                news.setCreatedBy(rs.getInt("Created_By"));
                news.setViewsCount(rs.getInt("ViewsCount"));
                news.setStatus(rs.getInt("Status"));
                return news;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<News> getNewsByStatus(int status) {
        String sql = "SELECT * FROM News WHERE status = ?";
        List<News> PublicNews = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, status);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsId(rs.getInt("NewsID"));
                news.setTitle(rs.getString("Title"));
                news.setContent(rs.getString("Content"));
                news.setCreatedDay(rs.getDate("Created_Day"));
                news.setThumbnail(rs.getString("Thumbnail"));
                news.setSummary(rs.getString("Summary"));
                news.setNumberCommment(rs.getInt("NumberComment"));
                news.setCreatedBy(rs.getInt("Created_By"));
                news.setViewsCount(rs.getInt("ViewsCount"));
                news.setStatus(rs.getInt("Status"));
                PublicNews.add(news);
            }
            return PublicNews;
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateNews(String title, String summary, String content, String thumbnail, int userId, int status, int newsId) {
        try {
            String strSQL = "UPDATE [dbo].[News] "
                    + "SET [Title] = ?,"
                    + "[Content] = ?,"
                    + "[Thumbnail] = ?,"
                    + "[Summary] = ?,"
                    + "[Status] = ? "
                    + "WHERE [NewsID] = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setString(3, thumbnail);
            statement.setString(4, summary);
            statement.setInt(5, status);
            statement.setInt(6, newsId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void updateNews(String title, String summary, String content, int userId, int status, int newsId) {
        try {
            String strSQL = "UPDATE [dbo].[News] "
                    + "SET [Title] = ?,"
                    + "[Content] = ?,"
                    + "[Summary] = ?,"
                    + "[Status] = ? "
                    + "WHERE [NewsID] = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setString(3, summary);
            statement.setInt(4, status);
            statement.setInt(5, newsId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void updateComment(String content, int commentID) {
        try {
            String strSQL = "UPDATE [NewsComment] SET [Content] = ? where [CommentID] = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);

            statement.setString(1, content);
            statement.setInt(2, commentID);

            // Execute the update
            int rowsUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public List<NewsComment> getCommentByUserID(int id) {
        String sql = "select * from NewsComment where UserID = ?";
        List<NewsComment> commentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NewsComment comment = new NewsComment();
                comment.setCommentId(rs.getInt("CommentID"));
                comment.setContent(rs.getString("Content"));
                comment.setCreatedDay(rs.getDate("Created_Day"));
                comment.setCreatedBy(rs.getInt("Created_By"));
                comment.setParentId(rs.getInt("ParentID"));
                comment.setNewsId(rs.getInt("NewsID"));

                commentList.add(comment);
            }
            return commentList;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<NewsComment> getCommentByNewsID(int id) {
        String sql = "select  NewsComment.CommentID\n"
                + ",NewsComment.Content, NewsComment.Created_Day,NewsComment.ParentID, NewsComment.NewsID,Account.Username "
                + "from NewsComment,Account where NewsID = ?"
                + " and NewsComment.Created_By = Account.UserID";
        List<NewsComment> commentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NewsComment comment = new NewsComment();
                comment.setCommentId(rs.getInt("CommentID"));
                comment.setContent(rs.getString("Content"));
                comment.setCreatedDay(rs.getDate("Created_Day"));
                comment.setName(rs.getString("Username"));
                comment.setParentId(rs.getInt("ParentID"));
                comment.setNewsId(rs.getInt("NewsID"));

                commentList.add(comment);
            }
            return commentList;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        new NewsDAO().updateNews("1", "2", "3", 1, 0, 1);
    }
}
