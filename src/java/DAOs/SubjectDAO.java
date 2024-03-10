/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Question;
import Models.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SubjectDAO extends DBContext<Subject> {

    @Override
    public ArrayList<Subject> list() {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "Select s.SubjectID,s.SubjectName\n"
                    + "from Subject s ";
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Subject subname = new Subject();
                    subname.setSubjectId(rs.getInt("SubjectID"));
                    subname.setSubjectName(rs.getString("SubjectName"));
                    list.add(subname);
                }
                // Other database operations
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Subject> getlist(String id) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "Select s.SubjectID,s.SubjectName from Subject s inner join SubjectDemension sd on s.SubDeID = sd.SubDeID\n"
                    + "where sd.SubDeID = ? ";
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Subject subname = new Subject();
                    subname.setSubjectId(rs.getInt("SubjectID"));
                    subname.setSubjectName(rs.getString("SubjectName"));
                    list.add(subname);
                }
                // Other database operations
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getIDbyName(String subname) {
        try {
            String sql = "Select s.SubjectID from Subject s\n"
                    + "where s.SubjectName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, subname);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt("SubjectID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void insert(Subject entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Subject entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Subject entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subject get(Subject entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
