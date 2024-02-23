/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author owner
 */
public class ClassSubject {
    private MyClass myClass;
    private Subject subject;
    private Teacher teacher;
    private Quiz quiz;

    public ClassSubject() {
    }

    public ClassSubject(MyClass myClass, Subject subject, Teacher teacher, Quiz quiz) {
        this.myClass = myClass;
        this.subject = subject;
        this.teacher = teacher;
        this.quiz = quiz;
    }

    public MyClass getMyClass() {
        return myClass;
    }

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    
}
