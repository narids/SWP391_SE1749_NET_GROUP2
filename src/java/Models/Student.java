/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author admin
 */
public class Student {
    private int UserID;
    private int StudentID;
    private int ClassID;

    public Student() {
    }

    public Student(int UserID, int StudentID, int ClassID) {
        this.UserID = UserID;
        this.StudentID = StudentID;
        this.ClassID = ClassID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    @Override
    public String toString() {
        return "Student{" + "UserID=" + UserID + ", StudentID=" + StudentID + ", ClassID=" + ClassID + '}';
    }
    
    
}
