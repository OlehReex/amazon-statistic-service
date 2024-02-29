package reex.statisticsgetter.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import reex.statisticsgetter.dto.UserRegistrationRequestDto;

public class FieldMatchValidator
        implements ConstraintValidator<FieldMatch, UserRegistrationRequestDto> {
    @Override
    public boolean isValid(UserRegistrationRequestDto registrationRequest,
                           ConstraintValidatorContext constraintValidatorContext) {
        return registrationRequest != null
                && registrationRequest.password().equals(registrationRequest.repeatPassword());
    }
}
