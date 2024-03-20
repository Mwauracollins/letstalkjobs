package org.simplifyinternships.simplifyinternships.services;

import org.simplifyinternships.simplifyinternships.dto.requests.UserRequest;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<BaseUser> findUserByEmail(String email);
    Optional<BaseUser> findByUsername(String username);
    List<UserRequest> findAllUsers();

}
