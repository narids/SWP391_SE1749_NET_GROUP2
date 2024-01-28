/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Account;
import Models.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owner
 */
public class AccountDAO extends DBContext<BaseEntity> {

    public Account getAccount(String UserName, String Password) {
        try {
            String sql = "SELECT Account.UserID, Account.Username, Account.Email, Account.Avatar, Account.Status, Role.RoleID, Role.RoleName\n"
                    + "FROM Account INNER JOIN\n"
                    + "Role ON Account.RoleID = Role.RoleID\n"
                    + "where Account.Username = ? and Account.Password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, UserName);
            stm.setString(2, Password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("Username"));
                account.setEmail(rs.getString("Email"));
                account.setAvatar(rs.getString("Avatar") != null ? rs.getString("Avatar") : "");
                account.setStatus(rs.getBoolean("Status"));

                Role role = new Role();
                role.setRoleId(rs.getInt("RoleID"));
                role.setRoleName(rs.getString("RoleName"));
                account.setRole(role);

                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Boolean checkExistedUser(String userName) {
        String sql = "SELECT * FROM Account where Username = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Boolean checkExistedEmail(String email) {
        String sql = "SELECT * FROM Account where Email = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void resetPass(String password, String email) {
        try {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [Password] = ?\n"
                    + " WHERE Email = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, email);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public ArrayList<Account> list() {
//
//        try {
//            ArrayList<Account> accounts = new ArrayList<>();
//
//            String sql = "SELECT   [User].*, Role.role_name\n"
//                    + "FROM     Role INNER JOIN\n"
//                    + "[User] ON Role.role_id = [User].role_id\n"
//                    + "where Role.role_id = 1";
//
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//                Account account = new Account();
//                account.setUserName(rs.getString("username"));
//                account.setPassword(rs.getString("password"));
//                account.setFullname(rs.getNString("fullname"));
//                account.setRollnumber(rs.getNString("rollnumber"));
//                account.setStatus(rs.getInt("status"));
//
//                Role role = new Role();
//                role.setId(rs.getInt("role_id"));
//                role.setRole(rs.getString("role_name"));
//                account.setRole(role);
//
//                accounts.add(account);
//            }
//
//            return accounts;
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public Account get(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void insert(Account model) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public Boolean updateStatusUser(Account a) {
//        try {
//            String sql = "UPDATE [dbo].[User]\n"
//                    + "   SET [status] = ?\n"
//                    + " WHERE username = ?";
//            connection.setAutoCommit(false);
//            PreparedStatement stm = connection.prepareCall(sql);
//
//            stm.setInt(1, a.getStatus());
//            stm.setString(2, a.getUserName());
//
//            if (stm.executeUpdate() > 0) {
//                connection.commit();
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return false;
//    }
//
//    @Override
//    public void update(Account model) {
//
//    }
//
//    @Override
//    public void delete(Account model) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    @Override
    public ArrayList<BaseEntity> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BaseEntity get(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
