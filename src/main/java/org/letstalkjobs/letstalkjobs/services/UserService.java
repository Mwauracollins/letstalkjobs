package org.letstalkjobs.letstalkjobs.services;

import org.letstalkjobs.letstalkjobs.dto.requests.UserRequest;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<BaseUser> findUserByEmail(String email);
    List<UserRequest> findAllUsers();

}
