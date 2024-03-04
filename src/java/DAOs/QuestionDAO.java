/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Answer;
import Models.News;
import Models.Question;
import Models.Subject;
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
public class QuestionDAO extends DBContext<Question> {

    @Override
    public ArrayList<Question> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Question get(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Question getQuestionByID(int id) {
        String sql = "SELECT q.QuestionID,q.Question_Content,q.Created_Day,q.ImageURL,a.Answer_Content,s.SubjectID,s.SubjectName\n"
                + "FROM [Question] q INNER JOIN [Answer] a ON q.QuestionID=a.QuestionID\n"
                + "				INNER JOIN [Subject] s ON q.SubjectID=s.SubjectID\n"
                + "		WHERE  q.QuestionID=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getInt("QuestionID"));
                ques.setQuestionContent(rs.getString("Content"));
                ques.setCreatedDay(rs.getDate("Created_Day"));
                ques.setImageURL(rs.getString("ImageURL"));
                Subject sub = new Subject();
                sub.setSubjectId(rs.getInt("SubjectID"));
                sub.setSubjectName(rs.getString("SubjectName"));
                ques.setSubject(sub);
                return ques;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addQuestion(String content, String image, String explain) {
        try {
            String strSQL = "INSERT INTO [dbo].[Question]"
                    + "([Question_Content],[Created_Day],"
                    + "[ImageURL],[Explain],[SubjectId],"
                    + "[AnswerID]) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setString(1, content);
            
            
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            statement.setString(3, image);
            statement.setString(4, explain);
            statement.setInt(5, 1);
            statement.setInt(6, 1);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void deleteQue(int id) {
        try {
            String strSQL = "DELETE FROM [Question] WHERE QuestionID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public ArrayList<Question> getQuesList() {
        ArrayList<Question> newList = new ArrayList<>();

        try {
            String strSQL = "select q.QuestionID,q.Question_Content,q.Explain,q.ImageURL,q.Created_Day,s.SubjectName from Question q Inner join Subject s on q.SubjectId = s.SubjectID  ";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question news = new Question();
                
                news.setQuestionId(resultSet.getInt("QuestionID"));
                news.setQuestionContent(resultSet.getString("Question_Content"));
                news.setCreatedDay(resultSet.getDate("Created_Day"));
                news.setImageURL(resultSet.getString("ImageURL"));
                news.setExplain(resultSet.getString("Explain"));
                Subject sub = new Subject();
                sub.setSubjectId(resultSet.getInt("SubjectID"));
                sub.setSubjectName(resultSet.getString("SubjectName"));
                news.setSubject(sub);
//                News n = new News(NewsID, Title, Content, Created_Day, Thumbnail);
//                newList.add(n);
                newList.add(news);
            }
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
        return newList;
    }
}
