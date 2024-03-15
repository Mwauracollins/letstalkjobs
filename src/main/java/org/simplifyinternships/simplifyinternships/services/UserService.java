package org.simplifyinternships.simplifyinternships.services;

import org.simplifyinternships.simplifyinternships.dto.UserDto;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserDto userDto);
    Optional<BaseUser> findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
