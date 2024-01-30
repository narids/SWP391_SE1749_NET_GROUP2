package Models;

import DAOs.BaseEntity;
import java.util.Date;

/**
 *
 * @author khanhlinh date 18/01/2024
 */
public class Quiz extends BaseEntity {

    /*Entity
    Table(name = "Quiz")
     */
    //GeneratedValue(strategy = GenerationType.IDENTITY)
    //Column(name = "QuizID")
    private int quizId;

    //Column(name = "Quiz_Content")
    private String quizContent;

    //Column(name = "Created_Day")
    private Date createdDay;

    public Quiz() {
    }

    public Quiz(int quizId, String quizContent, Date createdDay) {
        this.quizId = quizId;
        this.quizContent = quizContent;
        this.createdDay = createdDay;
    }

    // getters and setters
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
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

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", quizContent=" + quizContent + ", createdDay=" + createdDay + '}';
    }

}
