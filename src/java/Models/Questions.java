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
public class Questions {
    private int questionId;
    private int answerId;
    private String questionContent;
    private Date createdDay;
    private String imageURL;

    // Default constructor
    public Questions() {
    }

    // Parameterized constructor
    public Questions(int answerId, String questionContent, Date createdDay, String imageURL) {
        this.answerId = answerId;
        this.questionContent = questionContent;
        this.createdDay = createdDay;
        this.imageURL = imageURL;
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
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Questions{" +
                "questionId=" + questionId +
                ", answerId=" + answerId +
                ", questionContent='" + questionContent + '\'' +
                ", createdDay=" + createdDay +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
    
    
    
}
