package com.autoparts.userservice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(schema = "autoparts_shop", name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    //todo добавить в таблицу username colum
    private String username;
    private String password;
    private String email;

    @Column(name = "first_name")
    private String firstname;
    @Column(name = "second_name")
    private String lastname;
    //todo добавить в таблицу phone colum
    private String phone;
    //todo Переделать роль, в базу запишет id а обратно вернуть роль по айди не сможет при select
    @Enumerated(EnumType.STRING)
    private Role role;
    //todo Переделать статус, тоже самое что и с ролью
    @Enumerated(EnumType.STRING)
    private Status status;

    public UserEntity() {
    }

    public UserEntity(UUID id, String username, String password, String email, String firstname, String lastname, String phone, Role role, Status status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
