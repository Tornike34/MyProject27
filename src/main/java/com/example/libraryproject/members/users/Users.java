package com.example.libraryproject.members.users;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Users {
    private String name;
    @Column(unique = true)
    private String personalNumber;
    private String phoneNumber;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Users(String name, String personalNumber, String email, String phoneNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public Users() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }






    @Override
    public String toString() {
        return "DTOs{" +
                "name='" + name + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
