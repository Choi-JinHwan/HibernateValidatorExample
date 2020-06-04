package validation.example.appendix.spring.validator;

import validation.example.appendix.spring.StringBox;
import validation.example.appendix.spring.constraint.CustomConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomConstraintValidator implements ConstraintValidator<CustomConstraint, StringBox> {
	public void initialize(CustomConstraint constraint) {
	}

	public boolean isValid(StringBox obj, ConstraintValidatorContext context) {
		boolean isValid;
		if (obj == null || obj.getContent() == null) {
			return false;
		}

		isValid = obj.getContent().trim().length() > 0;

		return isValid;
	}
}
