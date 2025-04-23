package io.github.gabrielvelosoo.clientsapi.model.controller;

import io.github.gabrielvelosoo.clientsapi.model.dto.user.RequestUserDTO;
import io.github.gabrielvelosoo.clientsapi.model.entity.User;
import io.github.gabrielvelosoo.clientsapi.model.mapper.UserMapper;
import io.github.gabrielvelosoo.clientsapi.model.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController implements GenericController {

    private final UserService service;
    private final UserMapper userMapper;

    @PostMapping
    @Operation(summary = "Save", description = "Register new user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registered with success", content = @Content)
    })
    public ResponseEntity<Void> save(@RequestBody @Valid RequestUserDTO dto) {
        User user = userMapper.toEntity(dto);
        service.save(user);
        URI location = generateHeaderLocation(user.getId());
        return ResponseEntity.created(location).build();
    }
}
