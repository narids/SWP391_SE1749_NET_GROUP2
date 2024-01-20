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
    private int AnswerID;
    private int QuestionID;
    private boolean IsCorrect;
    private String Answer_Content;
    
    public Answer() {
    }  
    
    public Answer(int AnswerID, int QuestionID, boolean IsCorrect, String Answer_Content) {
        this.AnswerID = AnswerID;
        this.QuestionID = QuestionID;
        this.IsCorrect = IsCorrect;
        this.Answer_Content = Answer_Content;
    }

    public int getAnswerID() {
        return AnswerID;
    }

    public void setAnswerID(int AnswerID) {
        this.AnswerID = AnswerID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public boolean isIsCorrect() {
        return IsCorrect;
    }

    public void setIsCorrect(boolean IsCorrect) {
        this.IsCorrect = IsCorrect;
    }

    public String getAnswer_Content() {
        return Answer_Content;
    }

    public void setAnswer_Content(String Answer_Content) {
        this.Answer_Content = Answer_Content;
    }
    
    
}
