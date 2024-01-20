package Models;
import java.util.Date;

/**
 *
 * @author khanhlinh
 * date 18/01/2024
 */
public class Quiz {
    private int QuizID;
    private int QuestionID;
    private String Quiz_Content;
    private Date Created_Day;
    private int SubjectID;
    
    public Quiz(){
        
    }
    
   // Constructor
    public Quiz(int QuizID, int QuestionID, String Quiz_Content, Date Created_Day, int SubjectID) {
        this.QuizID = QuizID;
        this.QuestionID = QuestionID;
        this.Quiz_Content = Quiz_Content;
        this.Created_Day = Created_Day;
        this.SubjectID = SubjectID;
    }
        
    
    // getters and setters

    public int getQuizID() {
        return QuizID;
    }

    public void setQuizID(int QuizID) {
        this.QuizID = QuizID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getQuiz_Content() {
        return Quiz_Content;
    }

    public void setQuiz_Content(String Quiz_Content) {
        this.Quiz_Content = Quiz_Content;
    }

    public Date getCreated_Day() {
        return Created_Day;
    }

    public void setCreated_Day(Date Created_Day) {
        this.Created_Day = Created_Day;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    @Override
    public String toString() {
        return "Quiz{" + "QuizID=" + QuizID + ", QuestionID=" + QuestionID + ", Quiz_Content=" + Quiz_Content + ", Created_Day=" + Created_Day + ", SubjectID=" + SubjectID + '}';
    }


}
