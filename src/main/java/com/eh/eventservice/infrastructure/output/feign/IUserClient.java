package com.eh.eventservice.infrastructure.output.feign;

import com.eh.eventservice.domain.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${services.url-user}")
public interface IUserClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable Long id);

}
