package com.eh.eventservice.infrastructure.config;

import com.eh.eventservice.domain.api.IAuthenticationServicePort;
import com.eh.eventservice.domain.api.ICategoryServicePort;
import com.eh.eventservice.domain.spi.ICategoryPersistencePort;
import com.eh.eventservice.domain.usecase.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {

    private final ICategoryPersistencePort categoryPersistencePort;
    private final IAuthenticationServicePort authenticationServicePort;

    @Bean
    public ICategoryServicePort iCategoryServicePort(){
        return new CategoryService(categoryPersistencePort,authenticationServicePort );
    }

}
