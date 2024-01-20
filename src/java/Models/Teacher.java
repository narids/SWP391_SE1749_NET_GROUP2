/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author admin
 */
public class Teacher {
    private int UserID;
    private int ClassID;
    private int TeacherID;

    public Teacher() {
    }

    public Teacher(int UserID, int ClassID, int TeacherID) {
        this.UserID = UserID;
        this.ClassID = ClassID;
        this.TeacherID = TeacherID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    @Override
    public String toString() {
        return "Teacher{" + "UserID=" + UserID + ", ClassID=" + ClassID + ", TeacherID=" + TeacherID + '}';
    }
    
    
}
