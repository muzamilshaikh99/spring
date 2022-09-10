package com.sample.Project.prac.models;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@Entity
@Table(name="mydata")

public class users {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String LastName;
    private String Address;
    private String City;


    public users() {
    }
    public users(String FirstName, String lastName, String address, String city) {
        super();
        firstName = FirstName;
        LastName = lastName;
        Address = address;
        City = city;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String FirstName) {
        firstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }



}
