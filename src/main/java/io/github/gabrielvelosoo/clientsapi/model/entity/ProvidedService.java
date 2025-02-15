package io.github.gabrielvelosoo.clientsapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_provided_service", schema = "public")
@EntityListeners(AuditingEntityListener.class)
@Data
public class ProvidedService implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @CreatedDate
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
