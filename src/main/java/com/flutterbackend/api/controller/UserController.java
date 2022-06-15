package com.flutterbackend.api.controller;

import com.flutterbackend.business.UserService;
import com.flutterbackend.eDto.UserLoginRequest;
import com.flutterbackend.eDto.UserRegisterRequest;
import com.flutterbackend.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/sign-up")
    public ResponseEntity<?> saveUser(@RequestBody UserRegisterRequest registerRequest) {
        return new ResponseEntity<>(userService.saveUser(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }


}
