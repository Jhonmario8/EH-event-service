package com.eh.eventservice.domain.api;

import com.eh.eventservice.domain.model.Role;

public interface IAuthenticationServicePort {
    Role getCurrentUserRole();
    Long getCurrentUserId();
}
