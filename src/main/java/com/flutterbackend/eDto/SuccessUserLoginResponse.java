package com.flutterbackend.eDto;

import com.flutterbackend.entities.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SuccessUserLoginResponse(String token,
                                       LocalDateTime loginAttemptDate,
                                       User user) {
}
