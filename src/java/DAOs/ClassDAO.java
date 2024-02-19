/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.MyClass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public int getNumberOfStudentInClass(int ClassID) {
        String sql = "select COUNT (*) as count_student_in_class\n" +
"                from ClassStudent where ClassID = ?";
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
    public static void main(String[] args){
        ClassDAO  cd =  new ClassDAO();
        int num = cd.getNumberOfStudentInClass(1);
        System.out.println(num);
    }
}
