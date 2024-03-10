package Models;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author khanhlinh date 18/01/2024
 */
public class Quiz {

    private int quizId;
    private String quizName;
    private String quizContent;
    private String createdDate;
    private int quizStatus;
    private int time;

    public Quiz() {
    }

    public Quiz(int quizId, String quizName, String quizContent, String createdDate, int quizStatus, int time) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizContent = quizContent;
        this.createdDate = createdDate;
        this.quizStatus = quizStatus;
        this.time = time;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizContent() {
        return quizContent;
    }

    public void setQuizContent(String quizContent) {
        this.quizContent = quizContent;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(int quizStatus) {
        this.quizStatus = quizStatus;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", quizName=" + quizName + ", quizContent=" + quizContent + ", createdDate=" + createdDate + ", quizStatus=" + quizStatus + ", time=" + time + '}';
    }

}
