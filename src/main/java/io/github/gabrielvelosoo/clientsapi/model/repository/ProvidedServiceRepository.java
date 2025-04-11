package io.github.gabrielvelosoo.clientsapi.model.repository;

import io.github.gabrielvelosoo.clientsapi.model.entity.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, UUID>, JpaSpecificationExecutor<ProvidedService> {
}
