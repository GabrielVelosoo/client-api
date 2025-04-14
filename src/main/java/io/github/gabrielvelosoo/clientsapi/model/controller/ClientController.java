package io.github.gabrielvelosoo.clientsapi.model.controller;

import io.github.gabrielvelosoo.clientsapi.model.dto.client.RegisterClientDTO;
import io.github.gabrielvelosoo.clientsapi.model.dto.client.ResultSearchClientDTO;
import io.github.gabrielvelosoo.clientsapi.model.entity.Client;
import io.github.gabrielvelosoo.clientsapi.model.mapper.ClientMapper;
import io.github.gabrielvelosoo.clientsapi.model.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clients")
@RequiredArgsConstructor
public class ClientController implements GenericController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping
    @Operation(summary = "Save", description = "Register new client")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registered with success", content = @Content)
    })
    public ResponseEntity<Void> save(@RequestBody @Valid RegisterClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        clientService.save(client);
        URI url = generateHeaderLocation(client.getId());
        return ResponseEntity.created(url).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update", description = "Update a client")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Updated with success", content = @Content)
    })
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody @Valid RegisterClientDTO clientDTO) {
        return clientService.findById(fromString(id))
                .map(client -> {
                    Client clientEntity = clientMapper.toEntity(clientDTO);
                    client.setNome(clientEntity.getNome());
                    client.setCpf(clientEntity.getCpf());
                    clientService.update(client);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete", description = "Delete a client")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deleted with success", content = @Content)
    })
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return clientService.findById(fromString(id))
                .map(client -> {
                    clientService.delete(client);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @GetMapping
    public ResponseEntity<List<ResultSearchClientDTO>> findAll() {
        List<Client> clients = clientService.findAll();
        List<ResultSearchClientDTO> clientsDTO = clientMapper.toDTOs(clients);
        return ResponseEntity.ok(clientsDTO);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find by ID", description = "Find a client by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client found", content = @Content)
    })
    public ResponseEntity<ResultSearchClientDTO> findById(@PathVariable String id) {
        return clientService.findById(fromString(id))
                .map(client -> {
                    ResultSearchClientDTO clientDTO = clientMapper.toDTO(client);
                    return ResponseEntity.ok(clientDTO);
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }
}
