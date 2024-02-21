/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author User
 */
public class ClassStudent {
    private MyClass classID;
    private Student studentID;

    public ClassStudent() {
    }

    public ClassStudent(MyClass classID, Student studentID) {
        this.classID = classID;
        this.studentID = studentID;
    }

    public MyClass getClassID() {
        return classID;
    }

    public void setClassID(MyClass classID) {
        this.classID = classID;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }
    
}
