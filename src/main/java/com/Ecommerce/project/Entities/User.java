//   User.java
package com.Ecommerce.project.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")  // Avoids potential conflicts with SQL reserved keyword
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(unique = true)
    private String username;
    private String email;
    private String password;



    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}