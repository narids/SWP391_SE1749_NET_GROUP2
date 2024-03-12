/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Answer;
import Models.BaseEntity;
import Models.ClassSubject;
import Models.MyClass;
import Models.Question;
import Models.Quiz;
import Models.Subject;
import Models.SubjectDimension;
import Models.Teacher;
import Ultils.ConvertTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    public SubjectDimension getSubDeById(int id) {
        String sql = "SELECT * "
                + "FROM SubjectDemension "
                + "WHERE SubDeID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SubjectDimension subDe = new SubjectDimension(
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
                MyClass myClass = new MyClass();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();

                quiz.setQuizId(rs.getInt(1));
                quiz.setQuizName(rs.getString(2));
                quiz.setQuizContent(rs.getString(3));
                quiz.setCreatedDate(rs.getString(4));
                quiz.setQuizStatus(rs.getInt(5));

                myClass.setClassName(rs.getString(6));
                subject.setSubjectName(rs.getString(7));
                teacher.setTeacherId((String.valueOf(rs.getInt(8))));

                myClass.setClassID(rs.getInt("ClassID"));
                subject.setSubjectId(rs.getInt("SubjectID"));

                cs.setQuiz(quiz);
                cs.setMyClass(myClass);
                cs.setSubject(subject);
                cs.setTeacher(teacher);

                ltQuiz.add(cs);
            }

            return ltQuiz;
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ClassSubject> getQuizzesByStudentID(String sql) {
        List<ClassSubject> ltQuiz = new ArrayList<>();

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ClassSubject cs = new ClassSubject();
                Quiz quiz = new Quiz();
                MyClass myClass = new MyClass();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();

                quiz.setQuizId(rs.getInt(1));
                quiz.setQuizName(rs.getString(2));
                quiz.setQuizContent(rs.getString(3));
                quiz.setCreatedDate(rs.getString(4));
                quiz.setQuizStatus(rs.getInt(5));

                myClass.setClassName(rs.getString(6));
                subject.setSubjectName(rs.getString(7));
                teacher.setTeacherId((String.valueOf(rs.getInt(8))));

                myClass.setClassID(rs.getInt("ClassID"));
                subject.setSubjectId(rs.getInt("SubjectID"));

                cs.setQuiz(quiz);
                cs.setMyClass(myClass);
                cs.setSubject(subject);
                cs.setTeacher(teacher);

                ltQuiz.add(cs);
            }

            return ltQuiz;
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public Boolean addQuizQuestion(String quizID, String questionID) {
        String sql = "INSERT INTO [dbo].[QuizQuestion] ([QuizID] ,[QuestionID]) VALUES  (?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, quizID);
            stm.setString(2, questionID);

            if (stm.executeUpdate() > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Boolean removeQuestionInQuiz(String quizID, String questionID) {
        String sql = "DELETE FROM [dbo].[QuizQuestion]\n"
                + "      WHERE QuizID = ? and QuestionID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, quizID);
            stm.setString(2, questionID);

            if (stm.executeUpdate() > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Boolean removeAnswerById(String answerID) {
        String sql = "DELETE FROM [dbo].[Answer]\n"
                + "      WHERE AnswerID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, answerID);

            if (stm.executeUpdate() > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Boolean updateQuestionInQuiz(String questionID, String questionValue) {
        String sql = "UPDATE [dbo].[Question]\n"
                + "SET [Question_Content] = ?\n"
                + "WHERE QuestionID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, questionValue);
            stm.setString(2, questionID);

            if (stm.executeUpdate() > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Boolean updateAnswers(List<Answer> answers) {
        String sql = "";

        for (Answer a : answers) {
            int correct = a.isIsCorrect() ? 1 : 0;

            if (a.getAnswerId() != -1) {
                sql = sql + "UPDATE [dbo].[Answer] SET [IsCorrect] = " + correct + ",[Answer_Content] = '" + a.getAnswerContent() + "' WHERE AnswerID = " + a.getAnswerId() + " \n";
            } else {
                sql = sql + "INSERT INTO [dbo].[Answer] ([QuestionID], [IsCorrect], [Answer_Content]) VALUES (" + a.getQuestionId() + ", " + correct + " , '" + a.getAnswerContent() + "' ) \n";
            }
        }

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

    public Question getQuestionById(String id) {
        String sql = "SELECT Question.*, Answer.AnswerID, Answer.Answer_Content, Answer.IsCorrect\n"
                + "FROM Answer INNER JOIN Question \n"
                + "ON Answer.QuestionID = Question.QuestionID\n"
                + "where Question.QuestionID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            Question q = new Question();
            List<Answer> answers = new ArrayList<>();

            while (rs.next()) {
                q.setQuestionId(rs.getInt("QuestionID"));
                q.setQuestionContent(rs.getString("Question_Content"));
                q.setExplain(rs.getString("Explain") != null ? rs.getString("Explain") : "");
                q.setImageUrl(rs.getString("ImageURL") != null ? rs.getString("ImageURL") : "");

                Answer a = new Answer();
                a.setAnswerId(rs.getInt("AnswerID"));
                a.setAnswerContent(rs.getString("Answer_Content"));
                a.setIsCorrect(rs.getBoolean("IsCorrect"));

                answers.add(a);
            }

            q.setAnswers(answers);

            return q;
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public int setScore(int quizId, int userId, double score, int time) {
        int generatedId = -1;
        try {
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime createDateTime = currentDateTime.minusNanos(ConvertTime.secondsToTime(time).getTime() * 1000000L);
            Timestamp createTimestamp = Timestamp.valueOf(createDateTime);
            String strSelect = "INSERT INTO Test (QuizId, Score, UserId, Time, CreateDate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(strSelect, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1, quizId);
            stm.setDouble(2, score);
            stm.setInt(3, userId);
            stm.setInt(4, time);
            stm.setTimestamp(5, createTimestamp);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return generatedId;
    }

    public Quiz getQuizById(String id) {
        String sql = "SELECT * FROM Quiz where QuizID = '" + id + "'";

        if (id.trim().isEmpty()) {
            return null;
        }

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizId(rs.getInt(1));
                q.setQuizName(rs.getString(2));
                q.setQuizContent(rs.getString(3));
                q.setCreatedDate(rs.getString(4));
                q.setQuizStatus(rs.getInt(5));
                q.setTime(rs.getInt(6));
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Quiz getQuizById(int id) {
        String sql = "SELECT * FROM Quiz where QuizID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizId(rs.getInt(1));
                q.setQuizName(rs.getString(2));
                q.setQuizContent(rs.getString(3));
                q.setCreatedDate(rs.getString(4));
                q.setQuizStatus(rs.getInt(5));
                q.setTime(rs.getInt(6));
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public List<Quiz> getQuizList(int quizId, int quizContent, Date createdDay) {
        List<Quiz> quizList = new ArrayList<>();

        String sql = "SELECT [QuizID]\n"
                + "      ,[Quiz_Content]\n"
                + "      ,[Created_Day]\n"
                + "  FROM [dbo].[Quiz]";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizId(rs.getInt("QuizID"));
                quiz.setQuizContent(rs.getString("QuizContent"));
                quiz.setCreatedDate(rs.getString("CreatedDate"));
                quizList.add(quiz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quizList;
    }

    public static void main(String[] args) {
        QuizDAO q = new QuizDAO();
        System.out.println(q.getQuizById("1"));
//        List<Quiz> quizList = q.getQuizList(0, 0, createdDay);
//        for (Quiz quiz : quizList) {
//            System.out.println(quiz);
//        }
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
