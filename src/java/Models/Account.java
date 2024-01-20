/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nghia
 */
public class Account {
    private int UserID; 
    private String Username; 
    private int RoleID;
    private String Email; 
    private String Password; 
    private String Avatar; 

    public Account() {
    }

    public Account(int UserID, String Username, int RoleID, String Email, String Password, String Avatar) {
        this.UserID = UserID;
        this.Username = Username;
        this.RoleID = RoleID;
        this.Email = Email;
        this.Password = Password;
        this.Avatar = Avatar;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }
    
    
    
}
