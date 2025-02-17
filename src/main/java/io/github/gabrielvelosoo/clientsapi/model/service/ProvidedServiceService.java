package io.github.gabrielvelosoo.clientsapi.model.service;

import io.github.gabrielvelosoo.clientsapi.model.entity.ProvidedService;
import io.github.gabrielvelosoo.clientsapi.model.repository.ProvidedServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProvidedServiceService {

    private final ProvidedServiceRepository providedServiceRepository;

    public void save(ProvidedService service) {
        providedServiceRepository.save(service);
    }

    public void update(ProvidedService service) {
        providedServiceRepository.save(service);
    }

    public void delete(ProvidedService service) {
        providedServiceRepository.delete(service);
    }

    public Optional<ProvidedService> findById(UUID id) {
        return providedServiceRepository.findById(id);
    }
}
