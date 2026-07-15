package com.eh.eventservice.domain.usecase;

import com.eh.eventservice.domain.api.IAuthenticationServicePort;
import com.eh.eventservice.domain.api.ICategoryServicePort;
import com.eh.eventservice.domain.constants.DomainConstants;
import com.eh.eventservice.domain.exception.ConflictException;
import com.eh.eventservice.domain.exception.ForbiddenException;
import com.eh.eventservice.domain.model.Category;
import com.eh.eventservice.domain.model.Role;
import com.eh.eventservice.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class CategoryService implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;
    private final IAuthenticationServicePort authenticationServicePort;

    @Override
    public Category createCategory(Category category) {
       validateRole();
       categoryPersistencePort.findByName(category.getName()).ifPresent(category1 -> {
           throw new ConflictException(DomainConstants.MSG_CATEGORY_NAME_ALREADY_EXIST);
       });
       return categoryPersistencePort.saveCategory(category);

    }


    private void validateRole() {
        Role currentUserRole = authenticationServicePort.getCurrentUserRole();
        if (currentUserRole != Role.ADMIN) {
            throw new ForbiddenException(DomainConstants.MSG_ONLY_ADMIN_CAN_CREATE_CATEGORY);
        }
    }
}
