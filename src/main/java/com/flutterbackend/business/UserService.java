package com.flutterbackend.business;

import com.flutterbackend.dataAccess.UserRepository;
import com.flutterbackend.eDto.SuccessUserLoginResponse;
import com.flutterbackend.eDto.UserLoginRequest;
import com.flutterbackend.eDto.UserRegisterRequest;
import com.flutterbackend.entities.User;
import com.flutterbackend.exceptions.PasswordNotCorrectException;
import com.flutterbackend.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public User saveUser(UserRegisterRequest registerRequest) {
        User user = User.builder()
                .email(registerRequest.email())
                .password(registerRequest.password())
                .build();
        return userRepository.save(user);
    }

    @Transactional(readOnly = true, propagation = SUPPORTS)
    public SuccessUserLoginResponse login(UserLoginRequest loginRequest) {
        User userFromDb = findUserByEmail(loginRequest);

        if(!userFromDb.getPassword().equals(loginRequest.password())){
            throw new PasswordNotCorrectException("Password not correct!");
        }

        log.info("User login successful. "+userFromDb.getEmail());
        return SuccessUserLoginResponse.builder()
                .token(UUID.randomUUID().toString())
                .loginAttemptDate(LocalDateTime.now())
                .user(userFromDb)
                .build();
    }


    private User findUserByEmail(UserLoginRequest loginRequest) {
        return userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
