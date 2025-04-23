package io.github.gabrielvelosoo.clientsapi.model.service;

import io.github.gabrielvelosoo.clientsapi.model.entity.User;
import io.github.gabrielvelosoo.clientsapi.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
