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

    private int userId;
    private String teacherId;

    public Teacher() {
    }

    public Teacher(int userId, String teacherId) {
        this.userId = userId;
        this.teacherId = teacherId;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" + "userId=" + userId + ", teacherId=" + teacherId + '}';
    }

}
