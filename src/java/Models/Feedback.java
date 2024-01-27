/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author nghia
 */
public class Feedback {

    private int userID;
    private String content;
    private int feedbackId;
    private int rating;
    private int quizId;
    private Date reviewDate;

    public Feedback() {
    }

    public Feedback(int userID, String content, int feedbackId, int rating, int quizId, Date reviewDate) {
        this.userID = userID;
        this.content = content;
        this.feedbackId = feedbackId;
        this.rating = rating;
        this.quizId = quizId;
        this.reviewDate = reviewDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Feedback{" + "userID=" + userID + ", content=" + content + ", feedbackId=" + feedbackId + ", rating=" + rating + ", quizId=" + quizId + ", reviewDate=" + reviewDate + '}';
    }

}
