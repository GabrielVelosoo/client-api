package io.github.gabrielvelosoo.clientsapi.model.repository;

import io.github.gabrielvelosoo.clientsapi.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
