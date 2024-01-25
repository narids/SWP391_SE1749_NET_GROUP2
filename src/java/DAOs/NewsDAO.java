/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.News;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class NewsDAO extends DBContext<BaseEntity>{

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

//                News n = new News(NewsID, Title, Content, Created_Day, Thumbnail);
//                newList.add(n);

            }
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
        return newList;
    }

//    public User getUserById(String userId) {
//        try {
//            String strSQL = "select UserId, FullName, Password, Email, BirthDate, Address, Gender,Role from Users_HE140553 where UserId = ?";
//            PreparedStatement statement = connection.prepareStatement(strSQL);
//            statement.setString(1, userId);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                String fullName = resultSet.getString("FullName");
//                String password = resultSet.getString("Password");
//                String email = resultSet.getString("Email");
//                String birthDate = resultSet.getString("BirthDate");
//                String address = resultSet.getString("Address");
//                String gender = resultSet.getString("Gender");
//                String role = resultSet.getString("Role");
//                return new User(userId, fullName, password, email, birthDate, address, gender, role);
////                return new User(userId, fullName, password, email, birthDate, address, gender);
//            }
//        } catch (Exception e) {
//            System.out.println("getUserById: " + e.getMessage());
//        }
//        return null;
//    }
}
