/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Quiz;
import Models.Subject;
import Models.SubjectDemension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class QuizDAO extends DBContext<Quiz> {

    /**
     * Get 4 quizzes that haven't been assigned in order to show in homepage
     *
     * @return
     */
    public List<Quiz> getQuizForGuest() {
        List<Quiz> ltQuiz = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM Quiz q "
                + "WHERE q.QuizID "
                + "NOT IN "
                + "(SELECT c.QuizID "
                + "FROM ClassSubject c)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizId(rs.getInt("QuizID"));
                quiz.setQuizContent(rs.getString("Quiz_Content"));
                quiz.setCreatedDay(rs.getDate("Created_Day"));
                ltQuiz.add(quiz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltQuiz;
    }

    /**
     * Get first 3 subjects in order to show in homepage for guest
     *
     * @return
     */
    public List<Subject> getFirstThreeSubject() {
        List<Subject> ltSubject = new ArrayList<>();
        String sql = "SELECT TOP 3 * FROM Subject";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectId(rs.getInt("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setSubDetail(rs.getString("SubDetail"));
                subject.setSubDeId(rs.getInt("SubDeID"));
                subject.setSubDe(getSubDeById(rs.getInt("SubDeID")));
                ltSubject.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltSubject;
    }

    public SubjectDemension getSubDeById(int id) {
        String sql = "SELECT * "
                + "FROM SubjectDemension "
                + "WHERE SubDeID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SubjectDemension subDe = new SubjectDemension(
                        rs.getInt("SubDeID"),
                        rs.getString("SubDeName"),
                        rs.getString("SubDeDetail"));
                return subDe;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Quiz> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Quiz entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Quiz entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Quiz entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Quiz get(Quiz entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        QuizDAO q = new QuizDAO();
        List<Quiz> ltQuiz = q.getQuizForGuest();
        for (Quiz quiz : ltQuiz) {
            System.out.println(quiz);
        }
    }
}
