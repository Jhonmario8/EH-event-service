package com.eh.eventservice.infrastructure.output.feign;

import com.eh.eventservice.domain.model.User;
import com.eh.eventservice.domain.spi.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceAdapter implements IUserServicePort {

    private final IUserClient userClient;

    @Override
    public User findUserById(Long id) {
        return userClient.findById(id);
    }
}
