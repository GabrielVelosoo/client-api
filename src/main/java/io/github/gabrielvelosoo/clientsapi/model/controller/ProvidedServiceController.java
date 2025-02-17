package io.github.gabrielvelosoo.clientsapi.model.controller;

import io.github.gabrielvelosoo.clientsapi.model.dto.service.RegisterServiceDTO;
import io.github.gabrielvelosoo.clientsapi.model.dto.service.ResultSearchServiceDTO;
import io.github.gabrielvelosoo.clientsapi.model.entity.ProvidedService;
import io.github.gabrielvelosoo.clientsapi.model.mapper.ServiceMapper;
import io.github.gabrielvelosoo.clientsapi.model.service.ProvidedServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/services")
@RequiredArgsConstructor
public class ProvidedServiceController implements GenericController {

    private final ProvidedServiceService providedService;
    private final ServiceMapper serviceMapper;
    private final ProvidedServiceService providedServiceService;

    @PostMapping
    @Operation(summary = "Save", description = "Register new service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registered with success", content = @Content)
    })
    public ResponseEntity<Void> save(@RequestBody @Valid RegisterServiceDTO serviceDTO) {
        ProvidedService service = serviceMapper.toEntity(serviceDTO);
        providedService.save(service);
        URI url = generateHeaderLocation(service.getId());
        return ResponseEntity.created(url).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update", description = "Update a service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Updated with success", content = @Content)
    })
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody @Valid RegisterServiceDTO serviceDTO) {
        return providedService.findById(fromString(id))
                .map(service -> {
                    ProvidedService serviceEntity = serviceMapper.toEntity(serviceDTO);
                    service.setDescription(serviceEntity.getDescription());
                    service.setPrice(serviceEntity.getPrice());
                    service.setClient(serviceEntity.getClient());
                    providedService.update(service);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete", description = "Delete a service")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deleted with success", content = @Content)
    })
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return providedServiceService.findById(fromString(id))
                .map(service -> {
                    providedServiceService.delete(service);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find by ID", description = "Find a service by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Found service", content = @Content)
    })
    public ResponseEntity<ResultSearchServiceDTO> findById(@PathVariable String id) {
        return providedServiceService.findById(fromString(id))
                .map(service -> {
                    ResultSearchServiceDTO serviceDTO = serviceMapper.toDTO(service);
                    return ResponseEntity.ok(serviceDTO);
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }
}
