package io.github.gabrielvelosoo.clientsapi.model.service;

import io.github.gabrielvelosoo.clientsapi.model.entity.Client;
import io.github.gabrielvelosoo.clientsapi.model.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void update(Client client) {
        clientRepository.save(client);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }
}
