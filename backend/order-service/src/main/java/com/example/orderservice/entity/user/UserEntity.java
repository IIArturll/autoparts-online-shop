package com.example.orderservice.entity.user;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(schema = "autoparts_shop", name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    private String password;
    private String email;

    @Column(name = "first_name")
    private String firstname;
    @Column(name = "second_name")
    private String lastname;
    @Column(name = "phone_number")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusEntity status;

    public UserEntity() {
    }

    public UserEntity(UUID id, String password, String email, String firstname, String lastname, String phone,
                      RoleEntity role, StatusEntity status) {
        this.id = id;
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

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
}
