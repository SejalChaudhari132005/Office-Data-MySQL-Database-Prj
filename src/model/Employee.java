package model;

public class Employee {
    private String name;
    private String position;
    private String department;
    private String contact;

    public Employee(String name,String position,String department,String contact){
        this.name=name;
        this.position=position;
        this.department=department;
        this.contact=contact;
    }

    public String getName(){
        return this.name;
    }
    public String getPosition(){
        return this.position;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getContact(){
        return this.contact;
    }
}
