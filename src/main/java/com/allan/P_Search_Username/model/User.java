package com.allan.P_Search_Username.model;

import jakarta.persistence.*;

@Entity
@Table(name ="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_User")
    private Integer idUser;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name = "Lastname", length = 100, nullable = false)
    private String lastname;

    @Column(name = "User_mail", length = 100, nullable = false, unique = true)
    private String userMail;

    @Column(name = "Password", length = 100, nullable = false)
    private String password;

    @Column(name = "Status", nullable = false)
    private Integer status;

    // Constructor vacío (obligatorio para JPA)
    public User() {}

    // Getters y setters

    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
