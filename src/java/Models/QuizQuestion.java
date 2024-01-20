/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author khanhlinh
 */
public class QuizQuestion {
    private int QuizID;
    private int QuestionID;
    
    public QuizQuestion(){
    }
    
    public QuizQuestion(int quizID, int questionID){
        this.QuizID = QuizID;
        this.QuestionID = QuestionID;
    }
    
    //Getter and setter

    public int getQuizID() {
        return QuizID;
    }

    public void setQuizID(int quizID) {
        this.QuizID = QuizID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int questionID) {
        this.QuestionID = QuestionID;
    }
    
    // toString method for easy debugging
    @Override
    public String toString() {
        return "QuizQuestion{" + "QuizID=" + QuizID + ", QuestionID=" + QuestionID + '}';
    }
    
    
}
