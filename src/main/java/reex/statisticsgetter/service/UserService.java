package reex.statisticsgetter.service;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reex.statisticsgetter.dto.UserRegistrationRequestDto;
import reex.statisticsgetter.dto.UserResponseDto;
import reex.statisticsgetter.exception.RegistrationException;
import reex.statisticsgetter.mapper.UserMapper;
import reex.statisticsgetter.model.user.Role;
import reex.statisticsgetter.model.user.RoleName;
import reex.statisticsgetter.model.user.User;
import reex.statisticsgetter.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserResponseDto register(UserRegistrationRequestDto registrationRequest)
            throws RuntimeException {
        if (userRepository.existsByEmail(registrationRequest.email())) {
            throw new RegistrationException("Unable to complete registration.");
        }
        Role userRole = new Role();
        userRole.setName(RoleName.ROLE_USER);
        User userToSave = userMapper.toUser(registrationRequest);
        userToSave.setRoles(Set.of(userRole));
        userToSave.setPassword(passwordEncoder.encode(registrationRequest.password()));
        userRepository.save(userToSave);
        return userMapper.toUserResponseDto(userToSave);
    }
}
