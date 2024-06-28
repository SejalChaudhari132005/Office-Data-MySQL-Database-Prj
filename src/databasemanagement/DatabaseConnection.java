package databasemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private Statement statement;
    //constructor
    public DatabaseConnection(String databasename,String username,String password){
        try {
            String url="jdbc:mysql://localhost:3306/"+databasename;
            Connection connection= DriverManager.getConnection(url,username,password);
            System.out.println("Database connected successfully");
            this.statement=connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection unsuccessful.");
            e.printStackTrace();
        }
    }
    public Statement getStatement(){
        return this.statement;
    }
}
