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
import Models.Teacher;
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

    public ArrayList<ClassSubject> getlistQuiz(String id) {
        ArrayList<ClassSubject> list = new ArrayList<>();
        try {
            String sql = "SELECT Quiz.QuizID, Quiz.QuizName, Quiz.QuizContent, Quiz.CreatedDate, Quiz.QuizStatus, Class.ClassName, Subject.SubjectName, Teacher.TeacherID, Class.ClassID \n"
                        + "FROM         Class INNER JOIN\n"
                        + "                      ClassSubject ON Class.ClassID = ClassSubject.ClassID INNER JOIN\n"
                        + "                      Subject ON ClassSubject.SubjectID = Subject.SubjectID INNER JOIN\n"
                        + "                      Teacher ON ClassSubject.TeacherID = Teacher.TeacherID INNER JOIN\n"
                        + "                      Quiz ON ClassSubject.QuizID = Quiz.QuizID\n"
                        + "                      where Subject.SubjectID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ClassSubject cs = new ClassSubject();
                Quiz quiz = new Quiz();
                MyClass myClass = new MyClass();
                Subject subject = new Subject();
                Teacher teacher = new Teacher();

                quiz.setQuizId(rs.getInt("QuizID"));
                quiz.setQuizName(rs.getString("QuizName"));
                quiz.setQuizContent(rs.getString("QuizContent"));
                quiz.setCreatedDate(rs.getString("CreatedDate"));
                quiz.setQuizStatus(rs.getInt("QuizStatus"));

                myClass.setClassName(rs.getString("ClassName"));
                subject.setSubjectName(rs.getString("SubjectName"));
                teacher.setTeacherId(rs.getInt("TeacherID"));

                myClass.setClassID(rs.getInt("ClassID"));

                cs.setQuiz(quiz);
                cs.setMyClass(myClass);
                cs.setSubject(subject);
                cs.setTeacher(teacher);

                list.add(cs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Subject> getlist(String id) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "Select s.SubjectID,s.SubjectName,s.SubDetail from Subject s \n"
                    + "where s.SubDeID = ? ";
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Subject subname = new Subject();
                    subname.setSubjectId(rs.getInt("SubjectID"));
                    subname.setSubjectName(rs.getString("SubjectName"));
                    subname.setSubDetail(rs.getString("SubDetail"));
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
    public Subject getbyID(int id){
        Subject sub = new Subject();
        try {
            String sql = "Select s.SubjectName,s.SubDetail from Subject s\n"
                    + "where s.SubjectID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                sub.setSubjectName(rs.getString("SubjectName"));
                sub.setSubDetail(rs.getString("SubDetail"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sub;
    }
    public int getIDbyID(int id) {
        try {
            String sql = "Select s.SubDeID from Subject s\n"
                    + "where s.SubjectID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt("SubDeID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public void deleteClassSubject(int id){
        try {
            String strSQL = "DELETE FROM [ClassSubject] WHERE SubjectID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }
    public void deleteByID(int id){
         try {
            String strSQL = "DELETE FROM [Subject] WHERE SubjectID = ?";
            PreparedStatement statement = connection.prepareStatement(strSQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }

    public void addSubject(String name,String detail,String id){
        try {
            String sql = "insert into Subject (SubjectName,SubDetail,SubDeID) \n"
                    + "values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, detail);
            statement.setString(3, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
    }
   public void updateSubject(String name,String detail,int id) {
        try {
            String sql = "UPDATE [Subject] "
                    + "SET [SubjectName] = ?,"
                    + "[SubDetail] = ?"
                    + "WHERE [SubjectID] =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, detail);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("getListUsers:" + e.getMessage());
        }
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
