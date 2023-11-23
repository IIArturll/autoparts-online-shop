package com.autoparts.userservice.security;

import com.autoparts.userservice.core.enums.Role;
import com.autoparts.userservice.core.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@JsonIgnoreProperties({"enabled", "username", "authorities", "accountNonExpired",
        "credentialsNonExpired", "accountNonLocked"})
public class MyUserDetails implements UserDetails {
    private UUID id;
    private String email;
    private String password;
    private Role role;
    private Status status;

    public MyUserDetails() {
    }

    public MyUserDetails(UUID id, String email, String password, Role role, Status status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status == Status.DEACTIVATED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == Status.DEACTIVATED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return status == Status.ACTIVATED;
    }
}
