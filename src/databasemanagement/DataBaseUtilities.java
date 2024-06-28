package databasemanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Employee;

public class DataBaseUtilities {
    private Statement statement;
    private String tablename;
    public DataBaseUtilities(Statement statement,String tablename){
        this.statement=statement;
        this.tablename=tablename;

    }
    public void createTable(){
        try {
            this.statement.executeUpdate("create table "+this.tablename+"(name varchar(300), position varchar(300), department varchar(400), contact varchar(200));");
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println("Table already exist");
        }
    }

    public void insertEmployee(Employee e){
        try {
            this.statement.executeUpdate("insert into "+this.tablename+" values('"+e.getName()+"','"+e.getPosition()+"','"+e.getDepartment()+"','"+e.getContact()+"');");
            System.out.println("inserted successfully");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void showList() {
        try {
            ResultSet  employeelist=this.statement.executeQuery("select * from "+this.tablename+";");
            System.out.println("List:");
            while(employeelist.next()){
                System.out.println("Name:"+employeelist.getString("name")+"  Position:"+employeelist.getString("position")+"  Department:"+employeelist.getString("department")+"  Contact:"+employeelist.getString("contact")+";");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updatelist(String set,String update){
        try {
            this.statement.executeUpdate("update "+this.tablename+" set name= "+"'"+set+"'"+" where name ="+"'"+update+"';");
            System.out.println("Updated successfully");
        } catch (SQLException e) {
            System.out.println("Error in update");
            throw new RuntimeException(e);
        }
    }

    public void deletelist(String name){
        try {
            this.statement.executeUpdate("delete from "+this.tablename+" where name="+"'"+name+"';");
            System.out.println("Deleted successfully");
        } catch (SQLException e) {
            System.out.println("Error in delete");
            throw new RuntimeException(e);
        }
    }





}
