/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author owner
 */
public class Test {
    private int TestID;
    private int QuizID;
    private int UserID;
    private int Correct_Answer;
    private String StartTime;
    private String Completion_Date;
    private String EndTime;
    
    public Test() {
    }  

    public Test(int TestID, int QuizID, int UserID, int Correct_Answer, String StartTime, String Completion_Date, String EndTime) {
        this.TestID = TestID;
        this.QuizID = QuizID;
        this.UserID = UserID;
        this.Correct_Answer = Correct_Answer;
        this.StartTime = StartTime;
        this.Completion_Date = Completion_Date;
        this.EndTime = EndTime;
    }

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int TestID) {
        this.TestID = TestID;
    }

    public int getQuizID() {
        return QuizID;
    }

    public void setQuizID(int QuizID) {
        this.QuizID = QuizID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getCorrect_Answer() {
        return Correct_Answer;
    }

    public void setCorrect_Answer(int Correct_Answer) {
        this.Correct_Answer = Correct_Answer;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getCompletion_Date() {
        return Completion_Date;
    }

    public void setCompletion_Date(String Completion_Date) {
        this.Completion_Date = Completion_Date;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }
    
    
    
}
