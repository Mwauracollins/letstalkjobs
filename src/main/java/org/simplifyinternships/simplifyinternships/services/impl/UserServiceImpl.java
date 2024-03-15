package org.simplifyinternships.simplifyinternships.services.impl;

import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;
import org.simplifyinternships.simplifyinternships.auth.ChangePasswordRequest;
import org.simplifyinternships.simplifyinternships.dto.UserDto;
import org.simplifyinternships.simplifyinternships.entities.userentities.Applicant;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.simplifyinternships.simplifyinternships.repositories.UserRepository;
import org.simplifyinternships.simplifyinternships.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser.BaseUserBuilder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        BaseUserBuilder baseUserBuilder = new BaseUserBuilder(userDto.getEmail(), encodedPassword)
                .setUsername(userDto.getUsername())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setUserRole(UserRole.APPLICANT);
        BaseUser user = new BaseUser(baseUserBuilder);


        if (user.getUserRole() == UserRole.APPLICANT){
            Applicant applicant = new Applicant();
            applicant.setUser(user);
            user.setApplicant(applicant);
        }
        userRepository.save(user);
    }

    @Override
    public Optional<BaseUser> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<BaseUser> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(BaseUser user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }
    public void changePassword(@NotNull ChangePasswordRequest request, Principal connectedUser){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        //check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong Password");
        }
        //chech if the new password matches the confirm password
        if (!passwordEncoder.matches(request.getNewPassword(), request.getConfirmNewPassword())){
            throw new IllegalStateException("Passwordds do not match");
        }
        //update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);
    }
}
