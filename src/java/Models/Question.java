/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DAOs.BaseEntity;
import java.util.Date;

/**
 *
 * @author khanhlinh
 */
public class Question extends BaseEntity{

    private int questionId;
    private String questionContent;
    private Date createdDay;
    private String imageUrl;
    private String explain;
    private Subject subject;

    // Default constructor
    public Question() {
    }

    // Parameterized constructor
    public Question( String questionContent, Date createdDay, String imageUrl, String explain, Subject subject) {
        this.questionContent = questionContent;
        this.createdDay = createdDay;
        this.imageUrl = imageUrl;
        this.explain = explain;
        this.subject = subject;
    }

    // Getters and setters
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Question{" + "questionId=" + questionId +  ", questionContent=" + questionContent + ", createdDay=" + createdDay + ", imageUrl=" + imageUrl + ", explain=" + explain + ", subject=" + subject + '}';
    }

}
