/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author owner
 */
public class Subject {
    private int SubjectID;
    private String SubjectName;
    private int SubDeID;
    private String SubDetail;
    
    public Subject() {
    }

    public Subject(int SubjectID, String SubjectName, int SubDeID, String SubDetail) {
        this.SubjectID = SubjectID;
        this.SubjectName = SubjectName;
        this.SubDeID = SubDeID;
        this.SubDetail = SubDetail;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public int getSubDeID() {
        return SubDeID;
    }

    public void setSubDeID(int SubDeID) {
        this.SubDeID = SubDeID;
    }

    public String getSubDetail() {
        return SubDetail;
    }

    public void setSubDetail(String SubDetail) {
        this.SubDetail = SubDetail;
    }
    
    
}
