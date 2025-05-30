package io.github.gabrielvelosoo.clientsapi.model.repository;

import io.github.gabrielvelosoo.clientsapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
