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

    private int subjectId;
    private String subjectName;
    private int subDeId;
    private String subDetail;

    private SubjectDemension subDe;

    public Subject() {
    }

    public Subject(int subjectId, String subjectName, int subDeId, String subDetail, SubjectDemension subDe) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subDeId = subDeId;
        this.subDetail = subDetail;
        this.subDe = subDe;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubDeId() {
        return subDeId;
    }

    public void setSubDeId(int subDeId) {
        this.subDeId = subDeId;
    }

    public String getSubDetail() {
        return subDetail;
    }

    public void setSubDetail(String subDetail) {
        this.subDetail = subDetail;
    }

    public SubjectDemension getSubDe() {
        return subDe;
    }

    public void setSubDe(SubjectDemension subDe) {
        this.subDe = subDe;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectId=" + subjectId + ", subjectName=" + subjectName + ", subDeId=" + subDeId + ", subDetail=" + subDetail + ", subDe=" + subDe + '}';
    }

}
