package com.example.securityauthenticationservice.entity;


import com.example.securityauthenticationservice.core.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "user_status", schema = "autoparts_shop")
public class StatusEntity {
    @Id
    @GeneratedValue(generator = "status_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "status_seq", sequenceName = "user_status_id_seq",
            schema = "fitness", allocationSize = 1)
    private Short id;
    @Enumerated(EnumType.STRING)
    private Status status;

    public StatusEntity() {
    }

    public StatusEntity(Status status) {
        this.status = status;
        this.id = (short) (status.ordinal() + 1);
    }

    public Short getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
