/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.SubjectDimension;
import Models.Subject;
import Models.SubjectDimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SubjectDeDAO extends DBContext<SubjectDimension> {

    @Override
    public ArrayList<SubjectDimension> list() {
        ArrayList<SubjectDimension> list = new ArrayList<>();
        try {
            String sql = "Select s.SubDeID,s.SubDeName,s.SubDeDetail\n"
                    + "from SubjectDemension s ";
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    SubjectDimension subname = new SubjectDimension();
                    subname.setSubDeId(rs.getInt("SubDeID"));
                    subname.setSubDeName(rs.getString("SubDeName"));
                    subname.setSubDeDetail(rs.getString("SubDeDetail"));
                    list.add(subname);
                }
                // Other database operations
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addnew(String name, String detail) {
        try {
            String sql = "insert into SubjectDemension (SubDeName,SubDeDetail) \n"
                    + "values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, detail);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteByID(int id) {
        try {
            String strSQL = "delete SubjectDemension\n"
                    + " from SubjectDemension\n"
                    + " where SubjectDemension.SubDeID =  ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteByIDdd(int id) {
        try {
            String strSQL = "DELETE ClassSubject\n"
                    + " FROM ClassSubject  \n"
                    + "   join subject on  ClassSubject.SubjectID = Subject.SubjectID\n"
                    + "join SubjectDemension on Subject.SubDeID = SubjectDemension.SubDeID\n"
                    + "WHERE SubjectDemension.SubDeID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteByIDd(int id) {
        try {
            String strSQL = "delete Question\n"
                    + "from Question\n"
                    + "join Subject on Subject.SubjectID = Question.SubjectId\n"
                    + "join SubjectDemension on Subject.SubDeID = SubjectDemension.SubDeID\n"
                    + "where SubjectDemension.SubDeID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteByIDddd(int id) {
        try {
            String strSQL = "delete Subject\n"
                    + "from Subject\n"
                    + "join SubjectDemension on Subject.SubDeID = SubjectDemension.SubDeID\n"
                    + "where SubjectDemension.SubDeID =?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public SubjectDimension getbyID(int id) {
        SubjectDimension subname = new SubjectDimension();
        try {
            String sql = "Select *\n"
                    + "from SubjectDemension  where SubDeID=?";
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    subname.setSubDeId(rs.getInt("SubDeID"));
                    subname.setSubDeName(rs.getString("SubDeName"));
                    subname.setSubDeDetail(rs.getString("SubDeDetail"));
                }
                // Other database operations
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subname;
    }

    public SubjectDimension getbyIDfull(int id) {
        SubjectDimension subname = new SubjectDimension();
        try {
            String sql = "Select s.SubDeName,s.SubDeDetail,s.SubDeID\n"
                    + "from SubjectDemension s where s.SubDeID=?";
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    subname.setSubDeName(rs.getString("SubDeName"));
                    subname.setSubDeDetail(rs.getString("SubDeDetail"));
                    subname.setSubDeId(rs.getInt("SubDeID"));
                }
                // Other database operations
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subname;
    }

    public void updateDi(String name, String detail, int id) {
        try {
            String sql = "UPDATE [SubjectDemension] \n" +
"                    SET [SubDeName] = ?,\n" +
"                    [SubDeDetail] = ?\n" +
"                    WHERE [SubDeID] =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, detail);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    @Override
    public void insert(SubjectDimension entity) {
    }

    @Override
    public void update(SubjectDimension entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SubjectDimension entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SubjectDimension get(SubjectDimension entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
