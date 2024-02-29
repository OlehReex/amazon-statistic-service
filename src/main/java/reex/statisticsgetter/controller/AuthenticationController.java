package reex.statisticsgetter.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reex.statisticsgetter.dto.UserLoginRequestDto;
import reex.statisticsgetter.dto.UserLoginResponseDto;
import reex.statisticsgetter.dto.UserRegistrationRequestDto;
import reex.statisticsgetter.dto.UserResponseDto;
import reex.statisticsgetter.security.AuthenticationService;
import reex.statisticsgetter.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto loginRequestDto) {
        return authenticationService.authenticate(loginRequestDto);
    }

    @PostMapping("/register")
    public UserResponseDto register(
            @RequestBody @Valid UserRegistrationRequestDto registrationRequest)
            throws RuntimeException {
        return userService.register(registrationRequest);
    }
}
