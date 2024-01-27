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
        String sql = "SELECT s.ClassID, s.ClassName, a.Username\n"
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
