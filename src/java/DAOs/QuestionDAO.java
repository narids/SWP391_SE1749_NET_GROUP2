/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Answer;
import Models.ClassSubject;
import Models.MyClass;
import Models.Question;
import Models.Quiz;
import Models.Subject;
import Models.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owner
 */
public class QuestionDAO extends DBContext<BaseEntity> {

    public List<Question> getQuestionAndAnswersByQuizId(String id) {
        List<Question> ltQuestion = new ArrayList<>();

        String sql = "SELECT Question.QuestionID, Question.Question_Content\n"
                + "FROM Question INNER JOIN\n"
                + "QuizQuestion ON Question.QuestionID = QuizQuestion.QuestionID INNER JOIN\n"
                + "Quiz ON QuizQuestion.QuizID = Quiz.QuizID\n"
                + "where Quiz.QuizID = " + id;

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question();

                question.setQuestionId(rs.getInt("QuestionID"));
                question.setQuestionContent(rs.getString("Question_Content"));

                question.setAnswers(getAnswersByQuestionID(rs.getInt("QuestionID")));

                ltQuestion.add(question);
            }

            return ltQuestion;
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Answer> getAnswersByQuestionID(int id) {
        List<Answer> list = new ArrayList<>();

        String sql = "SELECT Answer.AnswerID, Answer.IsCorrect, Answer.Answer_Content\n"
                + "FROM Answer INNER JOIN\n"
                + "Question ON Answer.QuestionID = Question.QuestionID\n"
                + "where Question.QuestionID = " + id;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer();

                answer.setAnswerId(rs.getInt("AnswerID"));
                answer.setIsCorrect(rs.getBoolean("IsCorrect"));
                answer.setAnswerContent(rs.getString("Answer_Content"));

                list.add(answer);
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
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
