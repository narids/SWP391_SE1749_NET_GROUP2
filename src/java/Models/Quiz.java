
package Models;

import java.util.Date;

/**
 *
 * @author khanhlinh
 * date 18/01/2024
 */
public class Quiz {
    /*Entity
    Table(name = "Quiz")
    */
    //GeneratedValue(strategy = GenerationType.IDENTITY)
    //Column(name = "QuizID")
    private int quizId;
    
    //Column(name = "QuestionID")
    private int questionId;
    
    //Column(name = "Quiz_Content")
    private String quizContent;
    
    //Column(name = "Created_Day")
    private Date createdDay;
    
    //Column(name = "SubjectID")
    private int subjectId;

    // getters and setters

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuizContent() {
        return quizContent;
    }

    public void setQuizContent(String quizContent) {
        this.quizContent = quizContent;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    

}
