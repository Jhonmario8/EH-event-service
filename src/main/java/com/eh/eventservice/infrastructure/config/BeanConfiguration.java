package com.eh.eventservice.infrastructure.config;

import com.eh.eventservice.domain.api.IAuthenticationServicePort;
import com.eh.eventservice.domain.api.ICategoryServicePort;
import com.eh.eventservice.domain.api.IEventServicePort;
import com.eh.eventservice.domain.api.IReservationServicePort;
import com.eh.eventservice.domain.spi.ICategoryPersistencePort;
import com.eh.eventservice.domain.spi.IEventPersistencePort;
import com.eh.eventservice.domain.spi.IReservationPersistencePort;
import com.eh.eventservice.domain.spi.IUserServicePort;
import com.eh.eventservice.domain.usecase.CategoryService;
import com.eh.eventservice.domain.usecase.EventService;
import com.eh.eventservice.domain.usecase.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {

    private final ICategoryPersistencePort categoryPersistencePort;
    private final IAuthenticationServicePort authenticationServicePort;
    private final IEventPersistencePort eventPersistencePort;
    private final IReservationPersistencePort reservationPersistencePort;
    private final IUserServicePort userServicePort;

    @Bean
    public ICategoryServicePort iCategoryServicePort(){
        return new CategoryService(categoryPersistencePort,authenticationServicePort );
    }

    @Bean
    public IEventServicePort iEventServicePort(){
        return new EventService(eventPersistencePort,authenticationServicePort,categoryPersistencePort);
    }

    @Bean
    public IReservationServicePort iReservationServicePort(){
        return new ReservationService(reservationPersistencePort,eventPersistencePort,authenticationServicePort,userServicePort);
    }
}
