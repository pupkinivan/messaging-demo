package com.ivanpupkin.usersigninservice.mapper;

import com.ivanpupkin.usersigninservice.models.domain.User;
import com.ivanpupkin.usersigninservice.models.dto.UserSignInRequest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    User mapUserSignInRequestToUser (UserSignInRequest request);
}
