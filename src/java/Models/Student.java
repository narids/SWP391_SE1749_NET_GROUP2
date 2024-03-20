/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author admin
 */
public class Student extends BaseEntity {

    private int userId;
    private int studentId;

    private Account user;

    public Student() {
    }

    public Student(int userId, int studentId, Account user) {
        this.userId = userId;
        this.studentId = studentId;
        this.user = user;
    }

    public Student(int userId, int studentId, String name) {
        this.userId = userId;
        this.studentId = studentId;
        this.name = name;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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
