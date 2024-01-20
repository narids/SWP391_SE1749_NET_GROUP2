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
    private int quizID;
    private int questionID;
    
    public QuizQuestion(){
    }
    
    public QuizQuestion(int quizID, int questionID){
        this.quizID = quizID;
        this.questionID = questionID;
    }
    
    //Getter and setter

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
    
    // toString method for easy debugging
    @Override
    public String toString() {
        return "QuizQuestion{" + "quizID=" + quizID + ", questionID=" + questionID + '}';
    }
    
    
}
