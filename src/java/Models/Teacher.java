/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author admin
 */
public class Teacher extends BaseEntity {

    private int userId;
    private int teacherId;
    public Teacher() {
    }

    public Teacher(int userId, int teacherId) {
        this.userId = userId;
        this.teacherId = teacherId;
    }
    
    public Teacher(int userId, int teacherId, String name) {
        this.userId = userId;
        this.teacherId = teacherId;
        this.name = name;
    }

    public int getuserId() {
        return userId;
    }
    
     

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" + "userId=" + userId + ", teacherId=" + teacherId + '}';
    }

}
