/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.BaseEntity;
import Models.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public class TestDAO extends DBContext<BaseEntity> {

    public List<Test> getListScore(int userId) {
        List<Test> ltScore = new ArrayList<>();
        try {
            String strSelect = "SELECT * FROM Test WHERE UserID = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, userId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Test score = new Test();
                score.setTestId(rs.getInt("TestID"));
                score.setQuiz(new QuizDAO().getQuizById(rs.getString("QuizID")));
                score.setScore(rs.getFloat("Score"));
                score.setUserId(rs.getInt("UserId"));
                score.setQuizId(rs.getInt("QuizID"));
                score.setTime(rs.getInt("Time"));
                score.setCreateDate(rs.getDate("CreateDate"));
                ltScore.add(score);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ltScore;
    }

    public Test getTestById(int id) {
        try {
            String strSelect = "SELECT * FROM Test WHERE TestID = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Test score = new Test();
                score.setTestId(rs.getInt("TestID"));
                score.setQuiz(new QuizDAO().getQuizById(rs.getString("QuizID")));
                score.setScore(rs.getFloat("Score"));
                score.setUserId(rs.getInt("UserId"));
                score.setQuizId(rs.getInt("QuizID"));
                score.setTime(rs.getInt("Time"));
                return score;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
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
