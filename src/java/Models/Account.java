/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


/**
 *
 * @author owner
 */
public class Account extends BaseEntity {

    private int userId;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private Role role;
    private boolean status;
    private int roleId;
    private String fullName;

    public Account() {
    }

    public Account(int userId, String username, String email, String password, String avatar, Role role, boolean status, int roleId, String fullName) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.status = status;
        this.roleId = roleId;
        this.fullName = fullName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", avatar=" + avatar + ", role=" + role + ", status=" + status + ", roleId=" + roleId + ", fullName=" + fullName + '}';
    }

}
