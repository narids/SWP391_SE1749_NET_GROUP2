/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import DAOs.BaseEntity;

/**
 *
 * @author admin
 */
public class MyClass extends BaseEntity{

    private int classId;
    private String className;
    public MyClass() {
    }

    public MyClass(int classId, String className, String name) {
        this.classId = classId;
        this.className = className;
        this.name = name;
    }

    public MyClass(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }
    public int getClassID() {
        return classId;
    }

    public void setClassID(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class{" + "classId=" + classId + ", className=" + className + '}';
    }

}
