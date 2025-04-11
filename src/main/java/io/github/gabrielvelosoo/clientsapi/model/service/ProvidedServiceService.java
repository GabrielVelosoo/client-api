package io.github.gabrielvelosoo.clientsapi.model.service;

import io.github.gabrielvelosoo.clientsapi.model.entity.ProvidedService;
import io.github.gabrielvelosoo.clientsapi.model.repository.ProvidedServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static io.github.gabrielvelosoo.clientsapi.model.repository.specs.ProvidedServiceSpec.*;

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

    public List<ProvidedService> searchServices(String nome, Integer mes) {
        Specification<ProvidedService> specifications = searchServicesSpecification(nome, mes);
        return providedServiceRepository.findAll(specifications);
    }

    private Specification<ProvidedService> searchServicesSpecification(String nome, Integer mes) {
        Specification<ProvidedService> specs = Specification.where( (root, query, cb) -> cb.conjunction() );
        if(nome != null) {
          specs = specs.and(clienteNomeLike(nome));
        }
        if(mes != null) {
            specs = specs.and(mesEqual(mes));
        }
        return specs;
    }
}
