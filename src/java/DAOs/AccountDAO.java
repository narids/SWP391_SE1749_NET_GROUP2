/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Account;
import Models.BaseEntity;
import Models.Role;
import Models.Student;
import Models.Teacher;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
                account.setUserId(rs.getInt("UserID"));
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

    public Teacher getTeacher(String id) {
        try {
            String sql = "SELECT [UserID],[TeacherID]\n"
                    + "  FROM [Group2_SWP319_SE1749].[dbo].[Teacher]\n"
                    + "  where UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(id));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Teacher t = new Teacher();
                t.setuserId(rs.getInt(1));
                t.setTeacherId(rs.getInt(2));

                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Student getStudent(String id) {
        try {
            String sql = "SELECT [UserID],[StudentID]\n"
                    + "  FROM [Group2_SWP319_SE1749].[dbo].[Student]\n"
                    + "  where UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(id));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student t = new Student();
                t.setUserId(rs.getInt(1));
                t.setStudentId(rs.getInt(2));

                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTeacherByUserID(int id) {
        try {
            String sql = "SELECT [TeacherID]\n"
                    + "  FROM [Teacher]\n"
                    + "  where UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                int t = rs.getInt("TeacherID");
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Student getStudentByUserID(int id) {
        try {
            String sql = "SELECT [StudentID]\n"
                    + "  FROM [Student]\n"
                    + "  where UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Student t = new Student();
                t.setStudentId(rs.getInt("StudentID"));
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getTeacherFullname(int id) {
        try {
            String sql = "SELECT Teacher.UserID, Teacher.TeacherID, Account.Username, Account.Firstname, Account.Lastname\n"
                    + "FROM Account INNER JOIN Teacher\n"
                    + "ON Account.UserID = Teacher.UserID\n"
                    + "where Teacher.TeacherID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String f = rs.getString("Firstname");
                String l = rs.getString("Lastname");
                String full = f + " " + l;

                return full;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getStudentFullname(int id) {
        try {
            String sql = "SELECT Student.UserID, Student.StudentID, Account.Firstname, Account.Lastname\n"
                    + "FROM  Account INNER JOIN Student \n"
                    + "ON Account.UserID = Student.UserID\n"
                    + "where Student.StudentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String f = rs.getString("Firstname");
                String l = rs.getString("Lastname");
                String full = f + " " + l;

                return full;
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

    public Boolean checkExistedEmailOrUser(String email, String username) {
        String sql = "SELECT * FROM Account \n"
                + "where Username = ? OR Email = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, email);
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

    public int registerUser(Account a) {
        Integer generatedId = null;
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([Username]\n"
                    + "           ,[Password]\n"
                    + "           ,[RoleID]\n"
                    + "           ,[Email]\n"
                    + "           ,[Avatar]\n"
                    + "           ,[Status])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stm.setString(1, a.getUsername());
            stm.setString(2, a.getPassword());
            stm.setInt(3, a.getRole().getRoleId());
            stm.setString(4, a.getEmail());
            stm.setString(5, a.getAvatar());
            stm.setBoolean(6, a.getStatus());

            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = stm.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
                connection.commit();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return generatedId;
    }

    public Boolean addToStudentAccounts(int userID) {
        try {
            String sql = "INSERT INTO [dbo].[Student]\n"
                    + "           ([UserID])\n"
                    + "     VALUES\n"
                    + "           (?)";
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareCall(sql);

            stm.setInt(1, userID);

            if (stm.executeUpdate() > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Boolean addToTeacherAccounts(int userID) {
        try {
            String sql = "INSERT INTO [dbo].[Teacher]\n"
                    + "           ([UserID])\n"
                    + "     VALUES\n"
                    + "           (?)";
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareCall(sql);

            stm.setInt(1, userID);

            if (stm.executeUpdate() > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<Account> getAccountList() {
        List<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT a.*, r.RoleName FROM Account a LEFT JOIN Role r ON a.RoleID = r.RoleID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setUserId(rs.getInt("UserID"));
                a.setUsername(rs.getString("Username"));
                a.setPassword(rs.getString("Password"));
                a.setRoleId(rs.getInt("RoleID"));
                a.setEmail(rs.getString("Email"));
                a.setAvatar(rs.getString("Avatar"));
                a.setFullName(rs.getString("FullName"));
                a.setStatus(rs.getBoolean("Status"));
                a.setRole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));
                accounts.add(a);
            }
            return accounts;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Role> getRoleList() {
        List<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Role";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setRoleId(rs.getInt("RoleID"));
                r.setRoleName(rs.getString("RoleName"));
                roles.add(r);
            }
            return roles;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getAccountById(int id) {
        try {
            String sql = "SELECT a.*, r.RoleName FROM Account a LEFT JOIN Role r ON a.RoleID = r.RoleID WHERE a.UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setUserId(rs.getInt("UserID"));
                a.setUsername(rs.getString("Username"));
                a.setPassword(rs.getString("Password"));
                a.setRoleId(rs.getInt("RoleID"));
                a.setEmail(rs.getString("Email"));
                a.setAvatar(rs.getString("Avatar"));
                a.setFullName(rs.getString("FullName"));
                a.setStatus(rs.getBoolean("Status"));
                a.setRole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateAccount(int userId, String username, String fullname, String email, int roleId, boolean Status) {
        try {
            String sql = "UPDATE [dbo].[Account]  "
                    + "SET [Username] = ? ,"
                    + "[RoleID] = ? ,"
                    + "[Email] = ? ,"
                    + "[FullName] = ? ,"
                    + "[Status] = ? "
                    + "WHERE [UserID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setInt(2, roleId);
            stm.setString(3, email);
            stm.setString(4, fullname);
            stm.setBoolean(5, Status);
            stm.setInt(6, userId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertAccount(String username, String fullname, String email, int roleId, boolean Status, String password) {
        try {
            String sql = "INSERT INTO [dbo].[Account]"
                    + "([Username],"
                    + "[Password],"
                    + "[RoleID],"
                    + "[Email],"
                    + "[FullName],"
                    + "[Status]) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setInt(3, roleId);
            stm.setString(4, email);
            stm.setString(5, fullname);
            stm.setBoolean(6, Status);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public String generateRandomPassword(int len) {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public void updatefAccount(String name, String email, int id) {
        try {
            String sql = "UPDATE [Account]  "
                    + "SET [FullName] = ? ,"
                    + "[Email] = ? "
                    + "WHERE [UserID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, email);
            stm.setInt(3, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new AccountDAO().checkExistedEmailOrUser("asdasdsdas", "dasdaaa"));
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
