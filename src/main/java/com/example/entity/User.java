package com.example.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Niku on 01.04.2017.
 */
public class User {

    private int id;

    @Pattern(regexp="^(([A-Za-z]+)(\\s[A-Za-z]+)*)$", message="Invalid first name")
    @NotNull(message = "First Name is required")
    @Size(min=4, max=30, message="First Name must be between {min} and {max} characters long")
    private String firstName;

    @Pattern(regexp="^(([A-Za-z]+)(\\s[A-Za-z]+)*)$", message="Invalid last name")
    @NotNull(message = "Last Name is required")
    @Size(min=4, max=30, message="Last Name must be between {min} and {max} characters long")
    private String lastName;

    @NotNull(message = "Username is required")
    @Size(min=4, max=30, message="Username must be between {min} and {max} characters long")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min=4, max=30, message="Password must be between {min} and {max} characters long")
    private String password;

    @NotNull(message = "Password Coonfirmation is required")
    private String confirmPassword;

    private String[] roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
