/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Answer;

import Models.Question;
import Models.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owner
 */
public class QuestionDAO extends DBContext<Question> {

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

    public List<Question> getQuestionByQuiz(int quizId) {
        List<Question> ltQuestion = new ArrayList<>();
        try {
            String strSelect = "SELECT q1.*, QuizID FROM Question q1 \n"
                    + "                    LEFT JOIN QuizQuestion q2 \n"
                    + "                    ON q1.QuestionID = q2.QuestionID \n"
                    + "                    WHERE QuizID = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, quizId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question();

                question.setQuestionId(rs.getInt("QuestionId"));
                question.setQuestionContent(rs.getString("Question_Content"));
                question.setExplain(rs.getString("Explain"));
                question.setImageUrl(rs.getString("ImageURL"));
                Subject sub = new Subject();
                sub.setSubjectId(rs.getInt("SubjectId"));
                question.setSubject(sub);
                ltQuestion.add(question);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ltQuestion;
    }

    public Question getbyId(String id) {
        Question question = new Question();
        try {
            String strSelect = "Select q.QuestionID,q.Question_Content,s.SubjectName,a.Answer_Content,a.IsCorrect,q.Explain  from Question q left join Answer a on q.QuestionID =a.QuestionID\n"
                    + "inner join Subject s on q.SubjectId =s.SubjectID where q.QuestionID=?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                question.setQuestionId(rs.getInt("QuestionID"));
                question.setQuestionContent(rs.getString("Question_Content"));
                question.setAnswers(getAnswersByQuestionIDString(id));
                question.setExplain(rs.getString("Explain"));
                Subject sub = new Subject();
                sub.setSubjectName(rs.getString("SubjectName"));
                question.setSubject(sub);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return question;
    }

    public List<Answer> getAnswersByQuestionIDString(String id) {
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

    public List<Question> getQuestionAndAnswersBySubjectId(String quizID, String subjectID) {
        List<Question> ltQuestion = new ArrayList<>();

        String sql = "SELECT Question.QuestionID, Question.Question_Content, Question.Created_Day, Question.ImageURL, Question.Explain, Subject.SubjectID, Subject.SubjectName\n"
                + "FROM Question INNER JOIN Subject \n"
                + "ON Question.SubjectId = Subject.SubjectID\n"
                + "where Subject.SubjectID = " + subjectID
                + " AND NOT EXISTS ( SELECT  1 FROM QuizQuestion WHERE QuizQuestion.QuizID = " + quizID
                + " AND QuizQuestion.QuestionID = Question.QuestionID)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                Subject s = new Subject();

                question.setQuestionId(rs.getInt("QuestionID"));
                question.setQuestionContent(rs.getString("Question_Content"));
                question.setImageUrl(rs.getString("ImageURL"));
                question.setExplain(rs.getString("Explain"));

                question.setAnswers(getAnswersByQuestionID(rs.getInt("QuestionID")));

                s.setSubjectId(rs.getInt("SubjectID"));
                s.setSubjectName(rs.getString("SubjectName"));
                question.setSubject(s);

                ltQuestion.add(question);
            }

        } catch (SQLException ex) {
            return null;
        }

        return ltQuestion;
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

    public int numQuestionInQuiz(int quizId) {
        try {
            String strSelect = "SELECT COUNT(*) FROM QuizQuestion WHERE QuizId = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setInt(1, quizId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Question> lt = new QuestionDAO().getQuestionByQuiz(2);
        for (Question question : lt) {
            System.out.println(question);
        }
    }

    public void addQuestion(String content, String image, String explain, String subname) {
        try {
            String sql = "insert into Question (Question_Content,Created_Day,ImageURL,Explain,SubjectId) \n"
                    + "values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, content);
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            statement.setString(3, image);
            statement.setString(4, explain);
            SubjectDAO sub = new SubjectDAO();
            int subid = sub.getIDbyName(subname);
            statement.setInt(5, subid);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void updateByID(String content,String explain,String subject,int id) throws SQLException{
        String sql = "UPDATE [Question] "
                    + "SET [Question_Content] = ?,"
                    + "[Created_Day] = ?,"
                    + "[ImageURL] = ?,"
                    + "[Explain] = ? ,"
                    + "SubjectId=?"
                    + "WHERE [QuestionID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Create a PreparedStatement object
            statement.setString(1, content);
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            statement.setString(3, explain);
            statement.setString(4, explain);
            SubjectDAO sub = new SubjectDAO();
            int subid = sub.getIDbyName(subject);
            statement.setInt(5, subid);
            statement.setInt(6, id);
             statement.executeUpdate();
    }
    public void deleteByID(int id) {
        try {
            String strSQL = "DELETE FROM [Question] WHERE QuestionID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Question> list() {
        ArrayList<Question> lis = new ArrayList<>();
        try {
            String sql = "Select q.QuestionID, q.Question_Content,s.SubjectName \n"
                    + "from  Question q Inner join Subject s \n"
                    + "on q.SubjectId = s.SubjectID";
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Question ques = new Question();
                    ques.setQuestionId(rs.getInt("QuestionID"));
                    ques.setQuestionContent(rs.getString("Question_Content"));
                    Subject sub = new Subject();
                    sub.setSubjectName(rs.getString("SubjectName"));
                    ques.setSubject(sub);
                    lis.add(ques);
                }
                // Other database operations
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lis;
    }

    @Override
    public void insert(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Question get(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
