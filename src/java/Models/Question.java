/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author khanh
 */
public class Question {
    private int QuestionID;
    private int AnswerID;
    private String Question_Content;
    private Date Created_Day;
    private String ImageURL;
    
    public Question(){
        
    }
    
    public Question(int QuestionID,int AnswerID, String Question_Content, Date Created_Day, String ImageURL){
        this.QuestionID = QuestionID;
        this.AnswerID = AnswerID;
        this.Question_Content = Question_Content;
        this.Created_Day = Created_Day;
        this.ImageURL = ImageURL;
    }
    
    //Getter and setter
    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public int getAnswerID() {
        return AnswerID;
    }

    public void setAnswerID(int AnswerID) {
        this.AnswerID = AnswerID;
    }

    public String getQuestion_Content() {
        return Question_Content;
    }

    public void setQuestion_Content(String Question_Content) {
        this.Question_Content = Question_Content;
    }

    public Date getCreated_Day() {
        return Created_Day;
    }

    public void setCreated_Day(Date Created_Day) {
        this.Created_Day = Created_Day;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    @Override
    public String toString() {
        return "Question{" + "QuestionID=" + QuestionID + ", AnswerID=" + AnswerID + ", Question_Content=" + Question_Content + ", Created_Day=" + Created_Day + ", ImageURL=" + ImageURL + '}';
    }


    
    
}
