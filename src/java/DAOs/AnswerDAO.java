/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Answer;
import Models.BaseEntity;
import Models.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public class AnswerDAO extends DBContext<BaseEntity> {

    public float countScore(String[] selectedAnswers, int quizId) {
        float score = 0;
        float scorePerQuestion = 10.0f / new QuestionDAO().numQuestionInQuiz(quizId);
        List<Question> ltQuestion = new QuestionDAO().getQuestionByQuiz(quizId);
        for (Question question : ltQuestion) {
            List<String> correctAnswer = getCorrectedAnswersByQuestion(question.getQuestionId());
            List<String> selectedAnswer = getSelectedAnswerByQuestion(selectedAnswers, question.getQuestionId());
            if (correctAnswer.containsAll(selectedAnswer) && selectedAnswer.containsAll(correctAnswer)) {
                score += scorePerQuestion;
            }
        }
        return score;
    }

    public boolean isQuestionCorrect(String[] selectedAnswers, int questionId) {
        List<String> selectedAnswer = getSelectedAnswerByQuestion(selectedAnswers, questionId);
        List<String> correctAnswer = getCorrectedAnswersByQuestion(questionId);
        if (correctAnswer.containsAll(selectedAnswer) && selectedAnswer.containsAll(correctAnswer)) {
            return true;
        }
        return false;
    }

    public List<String> getCorrectedAnswersByQuestion(int questionId) {
        List<String> ltAnswer = new ArrayList<>();
        try {
            String strSelect = "SELECT AnswerID FROM Answer WHERE QuestionId = ? AND IsCorrect = 1";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, questionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ltAnswer.add(Integer.toString(rs.getInt(1)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ltAnswer;
    }

    public String[] getSelectedAnswerByScore(int scoreId) {
        try {
            List<String> ltAnswerRaw = new ArrayList<>();
            String strSelect = "SELECT AnswerID FROM TestQuestion WHERE TestID = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, scoreId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ltAnswerRaw.add(rs.getString(1));
            }
            String[] ltAnswer = new String[ltAnswerRaw.size()];
            for (int i = 0; i < ltAnswerRaw.size(); i++) {
                ltAnswer[i] = String.valueOf(ltAnswerRaw.get(i));
            }
            return ltAnswer;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<String> getSelectedAnswerByQuestion(String[] selectedAnswers, int questionId) {
        List<String> selectedAnswersForQuestion = new ArrayList<>();
        for (String selectedAnswer : selectedAnswers) {
            if (getAnswerById(Integer.parseInt(selectedAnswer)).getQuestionId() == questionId) {
                selectedAnswersForQuestion.add(selectedAnswer);
            }
        }
        return selectedAnswersForQuestion;
    }

    public Answer getAnswerById(int id) {
        try {
            String strSelect = "SELECT * FROM Answer WHERE AnswerId = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setAnswerId(rs.getInt("AnswerID"));
                answer.setAnswerContent(rs.getString("Answer_Content"));
                answer.setIsCorrect(rs.getBoolean("IsCorrect"));
                answer.setQuestionId(rs.getInt("QuestionID"));
//                answer.setQuestion(getQuestionById(rs.getInt("QuestionId")));
                return answer;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Answer> getAnswerByQuestion(int questionId) {
        List<Answer> ltAnswer = new ArrayList<>();
        try {
            String strSelect = "SELECT * FROM Answer WHERE QuestionID = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, questionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setAnswerId(rs.getInt("AnswerID"));
                answer.setAnswerContent(rs.getString("Answer_Content"));
//                answer.setTitle(rs.getString("Title"));
                answer.setIsCorrect(rs.getBoolean("IsCorrect"));
                answer.setQuestionId(rs.getInt("QuestionID"));
//                answer.setQuestion(getQuestionById(rs.getInt("QuestionId")));
                ltAnswer.add(answer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ltAnswer;
    }

    public void addAnswer(String content, String iscr, String id) {
        try {

            String strSelect = "INSERT INTO Answer (Answer_Content, IsCorrect) VALUES (?, ?) where QuestionID=?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setString(1, content);
            stm.setString(2, iscr);
            stm.setString(3, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void setSelectedAnswers(String[] selectedAnswers, int scoreId) {
        try {
            for (String selectedAnswer : selectedAnswers) {
                String strSelect = "INSERT INTO TestQuestion (TestID, AnswerID) VALUES (?, ?)";
                PreparedStatement stm = connection.prepareStatement(strSelect);
                stm.setInt(2, Integer.parseInt(selectedAnswer));
                stm.setInt(1, scoreId);
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteByID(int id){
        try {
            String strSQL = "DELETE FROM [Answer] WHERE QuestionID = ? ";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
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
