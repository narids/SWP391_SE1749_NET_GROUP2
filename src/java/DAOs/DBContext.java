/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.BaseEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Phu Nghia
 * Change: Ton Khanh Linh
 * Date: 22/01/2024
 * @param <T>
 */
public abstract class DBContext<T extends BaseEntity> {
    protected Connection connection;
    public DBContext() {
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Group2_SWP319_SE1749";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
public static void main(String[] args) {
    // Create an instance of DBContext to establish a database connection
    DBContext dbContext = new DBContext();

    // Check if the connection is not null, indicating a successful connection
    if (dbContext.connection != null) {
        System.out.println("Database connection is established successfully.");
        
        // You can add further code for testing or interacting with the database here
        
        // Close the database connection when done
        try {
            dbContext.connection.close();
            System.out.println("Database connection is closed.");
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        System.out.println("Failed to establish a database connection.");
    }
}
*/

}
