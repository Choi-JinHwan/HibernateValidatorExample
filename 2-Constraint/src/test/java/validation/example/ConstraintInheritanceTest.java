package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.example.mouse.MagicWallet;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@DisplayName("제약 상속 테스트")
public class ConstraintInheritanceTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test @DisplayName("상속 제약 누적")
	public void inheritanceConstraint(){
		MagicWallet wallet = new MagicWallet(-10);

		Set<ConstraintViolation<MagicWallet>> constraintViolations = validator.validate(wallet);

		printConstraintViolations(constraintViolations);
	}

	private  <T> void printConstraintViolations(Set<ConstraintViolation<T>> constraintViolations) {
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			System.out.println();
			System.out.println("제약 위반: " + constraintViolation.getMessage());
			System.out.println("메시지 템플릿: " + constraintViolation.getMessageTemplate());
			System.out.println("property path: " + constraintViolation.getPropertyPath().toString());
			System.out.println("================================================");
		}
	}
}
