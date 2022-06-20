package com.optum.reboot.azure.cosmosapp.cosmossampleapp.entities;

import com.azure.spring.data.cosmos.core.mapping.Container;

import java.util.Date;
import java.util.UUID;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "c1")
public class Employee {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public Date dateOfBirth;
    @PartitionKey
    public String state;

    public Employee() { super(); }

    public Employee(String firstName, String lastName, String email, Date dateOfBirth, String state) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.state = state;
    }
    public Employee(String id, String firstName, String lastName, String email, Date dateOfBirth, String state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", state='" + state + '\'' +
                '}';
    }
}

