package reex.statisticsgetter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import reex.statisticsgetter.validation.FieldMatch;

@FieldMatch
public record UserRegistrationRequestDto(
        @Email(regexp = "^[\\w-]+@[a-zA-Z\\d-]+\\.[a-zA-Z]{2,}$")
        String email,
        @NotBlank String name,
        @NotBlank @Size(min = 5, max = 60) String password,
        @NotBlank @Size(min = 5, max = 60) String repeatPassword) {
}
