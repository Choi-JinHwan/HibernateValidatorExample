package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("제약 위반 메시지 테스트")
public class ConstraintViolationMessageTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}


	@ParameterizedTest(name = "제약 위반 메시지 테스트 - {0}")
	@ValueSource(strings = {"A","A-123456789123456789"})
	public void messageTest(String licensePlate){
		// Given
		Car invalidCar = new Car(licensePlate);

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(invalidCar);

		// Then
		assertThat(constraintViolations.size()).isGreaterThan(0);

		constraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
	}


}