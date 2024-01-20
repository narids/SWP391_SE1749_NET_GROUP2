/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author admin
 */
public class Class {
    private int ClassID;
    private String ClassName;
    private int TeacherID;
    private int StudentID;
    private int SubjectID;

    public Class() {
    }

    public Class(int ClassID, String ClassName, int TeacherID, int StudentID, int SubjectID) {
        this.ClassID = ClassID;
        this.ClassName = ClassName;
        this.TeacherID = TeacherID;
        this.StudentID = StudentID;
        this.SubjectID = SubjectID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    @Override
    public String toString() {
        return "Class{" + "ClassID=" + ClassID + ", ClassName=" + ClassName + ", TeacherID=" + TeacherID + ", StudentID=" + StudentID + ", SubjectID=" + SubjectID + '}';
    }
    
    
}
