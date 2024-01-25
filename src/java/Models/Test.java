/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author owner
 */
public class Test {

    private int testId;
    private int quizId;
    private int userId;
    private int correctAnswer;
    private String startTime;
    private String completionDate;
    private String endTime;

    private Account user;
    private Quiz quiz;

    public Test() {
    }

    public Test(int testId, int quizId, int userId, int correctAnswer, String startTime, String completionDate, String endTime, Account user, Quiz quiz) {
        this.testId = testId;
        this.quizId = quizId;
        this.userId = userId;
        this.correctAnswer = correctAnswer;
        this.startTime = startTime;
        this.completionDate = completionDate;
        this.endTime = endTime;
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

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        return "Test{" + "testId=" + testId + ", quizId=" + quizId + ", userId=" + userId + ", correctAnswer=" + correctAnswer + ", startTime=" + startTime + ", completionDate=" + completionDate + ", endTime=" + endTime + ", user=" + user + ", quiz=" + quiz + '}';
    }

}
