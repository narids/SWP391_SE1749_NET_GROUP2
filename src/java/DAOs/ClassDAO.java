/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.MyClass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nghia
 */
public class ClassDAO extends DBContext<BaseEntity> {

//    public MyClass getClass(int classID) {
//        String sql = "SELECT * FROM Class WHERE ClassID = ?";
//        MyClass cls = null;
//        PreparedStatement statement;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, classID);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return new MyClass(resultSet.getInt("ClassID"), resultSet.getString("ClassName"));
//            } else {
//                return null;
//            }
//        } catch (SQLException ex) {
//
//        }
//        return cls;
//    }
    public List<MyClass> getAllClasses() {
        String sql = "SELECT distinct s.ClassID, s.ClassName, a.Username\n"
                + "FROM Class s, ClassSubject cs, Teacher t, Account a\n"
                + "WHERE s.ClassID = cs.ClassID AND cs.TeacherID = t.TeacherID AND a.UserID = t.UserID";
        List<MyClass> classes = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                classes.add(new MyClass(resultSet.getInt("ClassID"), resultSet.getString("ClassName"), resultSet.getString("Username")));
            }
            return classes;
        } catch (SQLException ex) {
            ;
        }
        return classes;
    }

    public List<MyClass> getClasses() {
        String sql = "SELECT *\n"
                + "FROM Class\n";
        List<MyClass> classes = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                classes.add(new MyClass(resultSet.getInt("ClassID"), resultSet.getString("ClassName")));
            }
            return classes;
        } catch (SQLException ex) {
            ;
        }
        return classes;
    }

    public MyClass getClassesByID(int id) {
        String sql = "SELECT * FROM Class WHERE ClassID = ?";
        MyClass myClass = null;
        try {
            // Check if connection is null or not
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id); // set the parameter for the query
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    myClass = new MyClass(resultSet.getInt("ClassID"), resultSet.getString("ClassName"));
                }
                // Close resultSet, statement, and connection (if necessary)
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
        return myClass; // Moved the return statement outside the try-catch block
    }

    public MyClass getClassesByName(String name) {
        String sql = "SELECT * FROM Class WHERE ClassName = ?";
        MyClass myClass = null;
        try {
            // Check if connection is null or not
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, name); // set the parameter for the query
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    myClass = new MyClass(resultSet.getInt("ClassID"), resultSet.getString("ClassName"));
                }
                // Close resultSet, statement, and connection (if necessary)
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
        return myClass; // Moved the return statement outside the try-catch block
    }

    public boolean checkClassName(String ClassName) {
        if (getClassesByName(ClassName) == null) {
            return false;
        }
        return true;
    }

//    public void addClassName(String className) {
//        String sql = "INSERT INTO Class (className) VALUES (?)";
//        try {
//            // Insert into Class table
//
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            statement.setString(1, className);
//            statement.executeUpdate();
//
//            // Close the statement and the connection
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public int addClassName(String ClassName) {
    String sql = "INSERT INTO Class (ClassName) VALUES (?)";
    int ClassID = 0;

    try (
        PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ) {
        pst.setString(1, ClassName);
        pst.executeUpdate();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                ClassID = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
    }

    return ClassID;
}


    public String getTeacherByClassID(int id) {
        String sql = "select distinct cs.TeacherID from ClassSubject cs, Class c, Teacher t, Account ac "
                + "where cs.ClassID = c.ClassID and"
                + " cs.TeacherID = t.TeacherID and t.UserID = ac.UserID and c.ClassID = ? ";
        String TeacherID = null;
        try {
            // Check if connection is null or not
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id); // set the parameter for the query
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    TeacherID = resultSet.getString("TeacherID");
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
        return TeacherID; // Moved the return statement outside the try-catch block
    }

    public List<String> getTeacherIDs() {
        String sql = "select TeacherID from Teacher";
        List<String> teacherIDs = new ArrayList<>();
        try {
            // Check if connection is null or not
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    teacherIDs.add(resultSet.getString("TeacherID"));
                }

                resultSet.close();
                statement.close();
            } else {
                System.err.println("Connection is null. Cannot execute query.");
            }
        } catch (SQLException ex) {
            // Log the exception or handle it appropriately
            ex.printStackTrace();
        }
        return teacherIDs;
    }

    public int getNumberOfStudentInClass(int ClassID) {
        String sql = "select COUNT (*) as count_student_in_class\n"
                + "                from ClassStudent where ClassID = ?";
        // declare and initialize the number of students in the class
        int numStudents = 0;

        PreparedStatement pst;
        try {
            pst = connection.prepareStatement(sql);
            // set the parameter value for the ClassID placeholder
            pst.setInt(1, ClassID);

            // declare and initialize the result set object
            ResultSet rs = pst.executeQuery();

            // check if the result set has any data
            if (rs.next()) {
                // assign the value of the count_student_in_class column to the variable
                numStudents = rs.getInt("count_student_in_class");
            }
            // close the result set, prepared statement, and connection objects

            rs.close();
            pst.close();
            connection.close();
            return numStudents;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // return the number of students in the class
        return numStudents;

    }

//    public int updateClasses(String teacherID, int classID) {
//        int rowsAffected = 0;
//        try {
//            String strSQL = "UPDATE [ClassSubject] "
//                    + "SET [TeacherID] = ?"
//                    + "WHERE [ClassID] = ?";
//            PreparedStatement statement = connection.prepareStatement(strSQL);
//            statement.setString(1, teacherID);
//            statement.setInt(2, classID);
//            rowsAffected = statement.executeUpdate();
//            connection.commit();  // commit the transaction
//        } catch (Exception e) {
//            System.out.println("getListUsers:" + e.getMessage());
//        }
//        return rowsAffected;
//    }
    public void updateClass(String teacherID, int classID) {
        try {
            String strSQL = "UPDATE [ClassSubject] "
                    + "SET [TeacherID] = ? "
                    + "WHERE [ClassID] = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setString(1, teacherID);
            statement.setInt(2, classID);
            statement.executeUpdate();

            // Commit the changes to the database
            connection.commit();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            // Rollback changes if necessary
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void AddClassTeacher(int ClassID, String TeacherID) {
        String sql = "INSERT Into ClassSubject(ClassID, TeacherID) VALUES(?,?)";
        try {
            // Insert into Class table

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ClassID);
            statement.setString(2, TeacherID);

            statement.executeUpdate();

            // Close the statement and the connection
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
    
    public int getIDfromClassName(String ClassName){ 
        String sql ="Select ClassID from Class where ClassName = ?"; 
        int ClassID = 0; 
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement(sql);
            // set the parameter value for the ClassID placeholder
            pst.setString(1, ClassName);

            // declare and initialize the result set object
            ResultSet rs = pst.executeQuery();

            // check if the result set has any data
            if (rs.next()) {
                // assign the value of the ClassID column to the variable
                ClassID = rs.getInt("ClassID");
            }
            // close the result set, prepared statement, and connection objects

            rs.close();
            pst.close();
            connection.close();
         
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // return the number of students in the class
        return ClassID;
        
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

    public static void main(String[] args) {
        ClassDAO cd = new ClassDAO();
        MyClass num = cd.getClassesByID(1);
        System.out.println(num);
    }
}
