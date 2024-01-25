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

    private int userId;
    private String studentId;

    private Account user;

    public Student() {
    }

    public Student(int userId, String studentId, Account user) {
        this.userId = userId;
        this.studentId = studentId;
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" + "userId=" + userId + ", studentId=" + studentId + ", user=" + user + '}';
    }

}
