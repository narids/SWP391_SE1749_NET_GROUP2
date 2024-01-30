/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author khanhlinh
 */
public class Question {

    private int questionId;
    private int answerId;
    private String questionContent;
    private Date createdDay;
    private String imageUrl;
    private String explain;
    private int subjectId;
    private Subject subject;

    // Default constructor
    public Question() {
    }

    // Parameterized constructor
    public Question(int answerId, String questionContent, Date createdDay, String imageUrl, String explain, int subjectId, Subject subject) {
        this.answerId = answerId;
        this.questionContent = questionContent;
        this.createdDay = createdDay;
        this.imageUrl = imageUrl;
        this.explain = explain;
        this.subjectId = subjectId;
        this.subject = subject;
    }

    // Getters and setters
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public void setImageURL(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Question{" + "questionId=" + questionId + ", answerId=" + answerId + ", questionContent=" + questionContent + ", createdDay=" + createdDay + ", imageUrl=" + imageUrl + ", explain=" + explain + ", subjectId=" + subjectId + ", subject=" + subject + '}';
    }

}
