package io.github.gabrielvelosoo.clientsapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_user", schema = "public")
@EntityListeners(AuditingEntityListener.class)
@Data
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime updatedAt;
}
