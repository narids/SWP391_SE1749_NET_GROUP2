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
    private int SubDeID;
    private String SubDeName;
    private String SubDeDetail;
    
    public SubjectDemension() {
    }

    public SubjectDemension(int SubDeID, String SubDeName, String SubDeDetail) {
        this.SubDeID = SubDeID;
        this.SubDeName = SubDeName;
        this.SubDeDetail = SubDeDetail;
    }

    public int getSubDeID() {
        return SubDeID;
    }

    public void setSubDeID(int SubDeID) {
        this.SubDeID = SubDeID;
    }

    public String getSubDeName() {
        return SubDeName;
    }

    public void setSubDeName(String SubDeName) {
        this.SubDeName = SubDeName;
    }

    public String getSubDeDetail() {
        return SubDeDetail;
    }

    public void setSubDeDetail(String SubDeDetail) {
        this.SubDeDetail = SubDeDetail;
    }
    
    
    
}
