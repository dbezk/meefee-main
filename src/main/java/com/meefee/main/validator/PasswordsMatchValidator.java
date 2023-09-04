package com.meefee.main.validator;

import com.meefee.main.annotation.PasswordsMatch;
import com.meefee.main.dto.settings.NewPasswordDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value instanceof NewPasswordDTO) {
            NewPasswordDTO dto = (NewPasswordDTO) value;
            return dto.getNewPassword() != null && dto.getNewPassword().equals(dto.getRetryNewPassword());
        }
        return false;
    }

}
