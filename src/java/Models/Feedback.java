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
    private int UserID;
    private String Content; 
    private int FeedbackID; 
    private int Rating; 
    private int QuizID;
    private Date ReviewDate;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public int getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(int FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public int getQuizID() {
        return QuizID;
    }

    public void setQuizID(int QuizID) {
        this.QuizID = QuizID;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date ReviewDate) {
        this.ReviewDate = ReviewDate;
    }

    public Feedback(int UserID, String Content, int FeedbackID, int Rating, int QuizID, Date ReviewDate) {
        this.UserID = UserID;
        this.Content = Content;
        this.FeedbackID = FeedbackID;
        this.Rating = Rating;
        this.QuizID = QuizID;
        this.ReviewDate = ReviewDate;
    }

    public Feedback() {
    }
    
}
