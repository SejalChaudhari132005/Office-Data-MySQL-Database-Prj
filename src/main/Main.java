package main;

import databasemanagement.DataBaseUtilities;
import databasemanagement.DatabaseConnection;
import model.Employee;
import validation.ValidationUtilities;

import java.util.Scanner;

import static validation.ValidationUtilities.*;


public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter database name:");
        String databasename=sc.nextLine();
        System.out.print("Enter username:");
        String username=sc.nextLine();
        System.out.print("Enter password:");
        String password=sc.nextLine();
        DatabaseConnection database=new DatabaseConnection(databasename,username,password);

        System.out.print("Enter tablename you want to create:");
        String tablename=sc.nextLine();
        DataBaseUtilities utils=new DataBaseUtilities(database.getStatement(),tablename);
        utils.createTable();
        ValidationUtilities.initialize();
        int option;
        do{
            System.out.println("1.Insert an employee");
            System.out.println("2.Show employee's list");
            System.out.println("3.Update name in list");
            System.out.println("4.Delete employee");
            System.out.println("5.Exit");
            System.out.print("Enter the option:");
            option= sc.nextInt();
            switch(option){
                case 1:
                    System.out.print("Enter name:");
                    String name=sc.next();
                    if(!validatename(name)){
                        System.out.println("Invalid name");
                        break;
                    }
                    System.out.print("Enter position:");
                    String position=sc.next();
                    if(!validateposition(position)){
                        System.out.println("Invalid position");
                        break;
                    }
                    System.out.print("Enter department:");
                    String department=sc.next();
                    if(!validatedepartment(department)){
                        System.out.println("Invalid department");
                        break;
                    }
                    System.out.print("Enter contact:");
                    String contact=sc.next();
                    if(!validatecontact(contact)){
                        System.out.println("Invalid contact");
                        break;
                    }

                    Employee e1 =new Employee(name,position,department,contact);
                    utils.insertEmployee(e1);
                    break;
                case 2:
                    utils.showList();
                    break;
                case 3:
                    System.out.print("Set name to:");
                    String set=sc.next();
                    System.out.print("Update:");
                    String update=sc.next();
                    utils.updatelist(set,update);
                    break;
                case 4:
                    System.out.print("Name of employee you want to delete:");
                    String employeename=sc.next();
                    utils.deletelist(employeename);
                    break;
                case 5:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }while(option<5);
    }
}
