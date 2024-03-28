/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.BaseEntity;
import Models.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nghia
 */
public class StudentDAO extends DBContext<BaseEntity> {

//    public List<Student> getStudentList() {
//        String sql = "SELECT s.UserID,s.StudentID,a.FullName from ClassStudent cs, Account a, Student s"
//                + " where cs.StudentID = s.StudentID\n"
//                + "and s.UserID = a.UserID ";
//        List<Student> StudentList = new ArrayList<>();
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                StudentList.add(new Student(resultSet.getInt("UserID"), resultSet.getInt("StudentID"),
//                        resultSet.getString("Fullname")));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return StudentList;
//    }
    public int getStudentIdByEmail(String email) {
        String sql = "SELECT s.StudentID from Student s, Account a \n"
                + "where a.UserID = s.UserID and a.Email = ? ";

        int StudentID = 0;
        try {
            // Check if connection is null or not
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, email); // set the parameter for the query
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    StudentID = resultSet.getInt("StudentID");
                }

                resultSet.close();
                statement.close();
                // No need to return myClass here, return it after try-catch block
            } else {
                System.err.println("Connection is null. Cannot execute query.");
            }
        } catch (SQLException ex) {
            // Log the exception or handle it appropriately
            ex.printStackTrace();
        }
        return StudentID; // Moved the return statement outside the try-catch block
    }

    public String getStudentNameByID(int id) {
        String sql = "SELECT StudentID, Fullname "
                + "from ClassStudent cs, Account a, Student s where cs.StudentID = s.StudentID\n"
                + "and s.UserID = a.UserID and cs.StudentID = ? ";
        String StudentName = null;

        try {
            // Check if connection is null or not
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id); // set the parameter for the query
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    StudentName = resultSet.getString("Fullname");
                }

                resultSet.close();
                statement.close();
                // No need to return myClass here, return it after try-catch block
            } else {
                System.err.println("Connection is null. Cannot execute query.");
            }
        } catch (SQLException ex) {
            // Log the exception or handle it appropriately
            ex.printStackTrace();
        }
        return StudentName; // Moved the return statement outside the try-catch block
    }

    public List<Student> getStudentIdByClassID(int ClassID) {
        String sql = "SELECT distinct a.UserID,s.StudentID,a.Fullname from ClassStudent cs,Student s,ClassSubject csj,Account a\n"
                + "where cs.ClassID = csj.ClassID and cs.StudentID = s.StudentID and a.UserID =s.UserID\n"
                + "and cs.ClassID =?";
        List<Student> StudentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ClassID); // set the parameter for the query
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StudentList.add(new Student(resultSet.getInt("UserID"), resultSet.getInt("StudentID"),
                        resultSet.getString("Fullname")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return StudentList;

    }

    public Account getAccountByStudentID(int studentID) {
        String sql = "SELECT Account.UserID, Account.Username, Account.Email, Account.Avatar, Account.Status,Role.RoleID,Role.RoleName\n"
                + "FROM account\n"
                + "INNER JOIN Role ON Account.RoleID = Role.RoleID\n"
                + "JOIN student ON account.UserID = student.UserID\n"
                + "WHERE student.StudentID =?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, studentID); // set the parameter for the query
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
//                Role role = new Role();
//                acc = new Account(resultSet.getInt("UserID"),resultSet.getString("Username"), resultSet.getString("Email"),resultSet.getString("Password"),
//                        resultSet.getString("Avatar"),role,resultSet.getBoolean("status"),resultSet.getInt("RoleID"),resultSet.getString("Fullname"));
                Account account = new Account();
                account.setUserId(rs.getInt("UserID"));
                account.setUsername(rs.getString("Username"));
                account.setEmail(rs.getString("Email"));
                account.setAvatar(rs.getString("Avatar") != null ? rs.getString("Avatar") : "");
                account.setStatus(rs.getBoolean("Status"));

                Role role = new Role();
                role.setRoleId(rs.getInt("RoleID"));
                role.setRoleName(rs.getString("RoleName"));
                account.setRole(role);
                return account;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

//    public void addStudentToClass( String StudentID,int ClassID) {
//        String sql = "INSERT into ClassStudent(StudentID,ClassID) VALUES(?,?)";
//        try {
//
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, StudentID);
//            statement.setInt(2, ClassID);
//
//            statement.executeUpdate();
//            connection.commit();
//         
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
    
       public boolean checkStudentName(int studentID) {
        if (getStudentNameByID(studentID) == null) {
            return false;
        }
        return true;
    }
    
    public void addStudentToClass(int studentID, int classID) {
        String sql = "INSERT INTO ClassStudent(StudentID, ClassID) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set parameters
            statement.setInt(1, studentID);
            statement.setInt(2, classID);

            // Execute the statement
            statement.executeUpdate();

            // Commit the transaction
        } catch (SQLException e) {
            // Rollback the transaction if an error occurs
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void removeStudentFromClassByStudentID(int id, int classId) {
        try {
            // Delete from ClassStudent table
            String strSQL = "DELETE FROM ClassStudent WHERE StudentID = ? and ClassID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.setInt(2, classId);
            statement.executeUpdate();

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteStudent:" + e.getMessage());
        }
    }

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

}
