/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author owner
 */
public class Answer {

    private int answerId;
    private int questionId;
    private boolean isCorrect;
    private String answerContent;
    private QuizQuestion quizQuestion;

    public Answer() {
    }

    public Answer(int answerId, int questionId, boolean isCorrect, String answerContent, QuizQuestion quizQuestion) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.isCorrect = isCorrect;
        this.answerContent = answerContent;
        this.quizQuestion = quizQuestion;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public QuizQuestion getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(QuizQuestion quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    @Override
    public String toString() {
        return "Answer{" + "answerId=" + answerId + ", questionId=" + questionId + ", isCorrect=" + isCorrect + ", answerContent=" + answerContent + ", quizQuestion=" + quizQuestion + '}';
    }

}
