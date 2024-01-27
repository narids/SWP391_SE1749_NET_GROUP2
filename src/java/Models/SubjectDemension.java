/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author owner
 */
public class SubjectDemension {

    private int subDeId;
    private String subDeName;
    private String subDeDetail;

    public SubjectDemension() {
    }

    public SubjectDemension(int subDeId, String subDeName, String subDeDetail) {
        this.subDeId = subDeId;
        this.subDeName = subDeName;
        this.subDeDetail = subDeDetail;
    }

    public int getSubDeId() {
        return subDeId;
    }

    public void setSubDeId(int subDeId) {
        this.subDeId = subDeId;
    }

    public String getSubDeName() {
        return subDeName;
    }

    public void setSubDeName(String subDeName) {
        this.subDeName = subDeName;
    }

    public String getSubDeDetail() {
        return subDeDetail;
    }

    public void setSubDeDetail(String subDeDetail) {
        this.subDeDetail = subDeDetail;
    }

    @Override
    public String toString() {
        return "SubjectDemension{" + "subDeId=" + subDeId + ", subDeName=" + subDeName + ", subDeDetail=" + subDeDetail + '}';
    }

}
