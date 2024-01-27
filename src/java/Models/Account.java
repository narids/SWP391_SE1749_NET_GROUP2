/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DAOs.BaseEntity;

/**
 *
 * @author owner
 */
public class Account extends BaseEntity {

    private int userId;
    private String username;
    private int roleId;
    private String email;
    private String password;
    private String avatar;
    private Role role;
    private boolean status;

    public Account() {
    }

    public Account(int userId, String username, int roleId, String email, String password, String avatar, Role role, boolean status) {
        this.userId = userId;
        this.username = username;
        this.roleId = roleId;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.status = status;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", username=" + username + ", roleId=" + roleId + ", email=" + email + ", password=" + password + ", avatar=" + avatar + ", role=" + role + ", status=" + status + '}';
    }

}
