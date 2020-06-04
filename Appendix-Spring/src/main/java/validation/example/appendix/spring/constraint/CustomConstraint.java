package validation.example.appendix.spring.constraint;

import validation.example.appendix.spring.validator.CustomConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, PARAMETER})
@Constraint(validatedBy = CustomConstraintValidator.class)
@Retention(RUNTIME)
public @interface CustomConstraint {

	String message() default "{custom.constraint.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
