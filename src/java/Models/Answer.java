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
    private Question question;

    public Answer() {
    }

    public Answer(int answerId, int questionId, boolean isCorrect, String answerContent) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.isCorrect = isCorrect;
        this.answerContent = answerContent;
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

    @Override
    public String toString() {
        return "Answer{" + "answerId=" + answerId + ", questionId=" + questionId + ", isCorrect=" + isCorrect + ", answerContent=" + answerContent +   '}';
    }

}
