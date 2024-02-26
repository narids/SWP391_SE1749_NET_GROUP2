/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.ClassSubject;
import Models.MyClass;
import Models.Question;
import Models.Quiz;
import Models.Subject;
import Models.SubjectDemension;
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
 * @author admin
 */
public class QuizDAO extends DBContext<BaseEntity> {

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
                quiz.setQuizName(rs.getString("QuizName"));
                quiz.setQuizContent(rs.getString("QuizContent"));
                quiz.setCreatedDate(rs.getString("CreatedDate"));
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

    public List<Quiz> getQuizzes(String sql) {
        List<Quiz> ltQuiz = new ArrayList<>();

        if (sql == null) {
            sql = "SELECT * FROM Quiz";
//             WHERE Quiz_Content LIKE ?;
//            stm.setString(1, "%" + keyword + "%");
        }

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizId(rs.getInt("QuizID"));
                quiz.setQuizName(rs.getString("QuizName"));
                quiz.setQuizContent(rs.getString("QuizContent"));
                quiz.setCreatedDate(rs.getString("CreatedDate"));
                ltQuiz.add(quiz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltQuiz;
    }
    public List<ClassSubject> getQuizzesByTeacherID(String sql) {
        List<ClassSubject> ltQuiz = new ArrayList<>();

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ClassSubject cs = new ClassSubject();
                Quiz quiz = new Quiz();
                MyClass myClass =new MyClass();
                Subject subject = new Subject();
                
                
                quiz.setQuizId(rs.getInt(1));
                quiz.setQuizName(rs.getString(2));
                quiz.setQuizContent(rs.getString(3));
                quiz.setCreatedDate(rs.getString(4));
                quiz.setQuizStatus(rs.getInt(7));
                
                myClass.setClassName(rs.getString(5));
                subject.setSubjectName(rs.getString(6));
                
                cs.setQuiz(quiz);
                cs.setMyClass(myClass);
                cs.setSubject(subject);
                
                ltQuiz.add(cs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltQuiz;
    }
    
    public Boolean updateQuizWithSql(String sql) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareCall(sql);

            if (stm.executeUpdate() > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * Get all questions for searching
     *
     * @param keyword
     * @return
     */
    public List<Question> getQuestions(String keyword) {
        List<Question> ltQuestion = new ArrayList<>();
        String sql = "SELECT * FROM Question WHERE Question_Content LIKE ?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + keyword + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setQuestionId(rs.getInt("QuestionID"));
                question.setQuestionContent(rs.getString("Question_Content"));
                question.setSubject(getSubjectById(rs.getInt("SubjectID")));
                ltQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltQuestion;
    }

    /**
     * Get all classes for searching
     *
     * @param keyword
     * @return
     */
    public List<MyClass> getClasses(String keyword) {
        List<MyClass> ltClass = new ArrayList<>();
        String sql = "SELECT * FROM Class WHERE ClassName LIKE ?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + keyword + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                MyClass c = new MyClass();
                c.setClassID(rs.getInt("ClassID"));
                c.setClassName(rs.getString("ClassName"));
                ltClass.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltClass;
    }

    /**
     * Get subject by SubjectID
     *
     * @param id
     * @return
     */
    public Subject getSubjectById(int id) {
        String sql = "SELECT * "
                + "FROM Subject "
                + "WHERE SubjectID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectId(rs.getInt("SubjectID"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setSubDetail(rs.getString("SubDetail"));
                subject.setSubDe(getSubDeById(rs.getInt("SubDeID")));
                return subject;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Get number of questions in a quiz
     *
     * @return
     */
    public int getQuestionNum(int quizId) {
        String sql = "SELECT COUNT(*) FROM QuizQuestion WHERE QuizID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quizId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Get number of students in a class
     *
     * @param classId
     * @return
     */
    public int getStudentNum(int classId) {
        String sql = "SELECT COUNT(*) FROM ClassStudent WHERE ClassID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, classId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        QuizDAO q = new QuizDAO();
        List<Quiz> ltQuiz = q.getQuizForGuest();
        for (Quiz quiz : ltQuiz) {
            System.out.println(quiz);
        }
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

    @Override
    public ArrayList<BaseEntity> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
