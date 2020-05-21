package validation.example;

import org.junit.jupiter.api.*;
import validation.example.car.Car;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarTest {

	Validator validator;

	@BeforeEach
	public void setValidator(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Order(1)
	@Test @DisplayName("기본 제약 테스트")
	public void basicValidateTest(){
		// Given
		Car car = new Car("A-1234", 4);

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

		//Then
		assertThat(constraintViolations.size()).isEqualTo(0);
	}

	@Order(2)
	@Test @DisplayName("licensePlate 최대 글자 수 초과 테스트")
	public void violationTest(){
		// Given
		Car car = new Car("A-1234567890101112", 4);

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

		// Then
		assertThat(constraintViolations.size()).isGreaterThan(0);

		for (ConstraintViolation<Car> constraintViolation : constraintViolations) {
			System.out.println("메시지 템플릿: "+constraintViolation.getMessageTemplate());
			System.out.println("제약 위반: "+constraintViolation.getMessage());
			System.out.println("property path: "+constraintViolation.getPropertyPath().toString());
			System.out.println("group: "+constraintViolation.getConstraintDescriptor().getGroups());
			System.out.println("payload: "+constraintViolation.getConstraintDescriptor().getPayload());
			System.out.println("======================================================");
		}

	}

}
