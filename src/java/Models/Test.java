/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author owner
 */
public class Test {

    private int testId;
    private int quizId;
    private int userId;
    private float score;
    private int time;
    private Date createDate;

    private Account user;
    private Quiz quiz;

    public Test() {
    }

    public Test(int testId, int quizId, int userId, float score, int time, Date createDate, Account user, Quiz quiz) {
        this.testId = testId;
        this.quizId = quizId;
        this.userId = userId;
        this.score = score;
        this.time = time;
        this.createDate = createDate;
        this.user = user;
        this.quiz = quiz;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Test{" + "testId=" + testId + ", quizId=" + quizId + ", userId=" + userId + ", score=" + score + ", time=" + time + ", createDate=" + createDate + ", user=" + user + ", quiz=" + quiz + '}';
    }

}
