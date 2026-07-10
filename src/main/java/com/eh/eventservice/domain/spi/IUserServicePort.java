package com.eh.eventservice.domain.spi;


import com.eh.eventservice.domain.model.User;

public interface IUserServicePort {

    User findUserById(Long id);

}
