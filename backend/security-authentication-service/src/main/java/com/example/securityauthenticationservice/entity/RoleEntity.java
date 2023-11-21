package com.example.securityauthenticationservice.entity;

import com.example.securityauthenticationservice.core.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role", schema = "autoparts_shop")
public class RoleEntity {
    @Id
    @GeneratedValue(generator = "role_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_seq", sequenceName = "user_role_id_seq",
            schema = "fitness", allocationSize = 1)
    private Short id;
    @Enumerated(EnumType.STRING)
    private Role role;

    public RoleEntity() {
    }

    public RoleEntity(Role role) {
        this.role = role;
        this.id = (short) (role.ordinal() + 1);
    }

    public Short getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
