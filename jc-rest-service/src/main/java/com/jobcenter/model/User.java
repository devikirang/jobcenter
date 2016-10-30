package com.jobcenter.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    private String email;
    private String password;
    private String name;
    private Role role;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String name, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Default to interviewee
     * @return User Role.
     */
    public Role getRole() {
        if (role == null) {
            role = Role.INTERVIEWEE;
        }
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Returns false if the user is Recruiter or Manager.
     *
     * @return boolean value based on user role.
     */
    public boolean isInterviewee() {
        if (this.getRole() == Role.RECURITER || this.getRole() == Role.INTERVIWER) {
            return false;
        }
        return true;
    }
}
