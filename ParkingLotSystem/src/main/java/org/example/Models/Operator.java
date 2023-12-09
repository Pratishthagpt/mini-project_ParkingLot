package org.example.Models;

public class Operator extends BaseModel{
    private String emp_Id;
    private String name;

    public Operator(String emp_Id, String name) {
        this.emp_Id = emp_Id;
        this.name = name;
    }

    /*------------------------------Getters and Setters-----------------------------*/
    public String getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
