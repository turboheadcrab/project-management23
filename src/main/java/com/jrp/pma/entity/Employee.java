package com.jrp.pma.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    private String firstName;
    private String lastName;
    private String email;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project theProject;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, Project project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.theProject = project;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Project getTheProject() {
        return theProject;
    }

    public void setTheProject(Project theProject) {
        this.theProject = theProject;
    }
}
