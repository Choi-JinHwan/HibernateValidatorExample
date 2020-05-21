package validation.example;

import org.junit.jupiter.api.*;
import validation.example.car.Car;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Validator method Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidatorMethodTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		validator = Validation.buildDefaultValidatorFactory().getValidator();

		assertThat(validator).isNotNull();
	}

	@DisplayName("Validator#validate")
	@Test @Order(1)
	public void validate(){
		Car car = new Car(null, 0);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

		assertThat(constraintViolations.size()).isEqualTo(3);

		printConstraintViolationMessage(constraintViolations);
	}

	@DisplayName("Validator#validateProperty")
	@Test @Order(2)
	public void validateProperty(){
		Car car = new Car(null, 0);
		Set<ConstraintViolation<Car>> constraintViolations = validator.validateProperty(car,"seatCount");

		assertThat(constraintViolations.size()).isEqualTo(1);

		printConstraintViolationMessage(constraintViolations);
	}

	@DisplayName("Validator#validateValue")
	@Test @Order(3)
	public void validateValue(){
		Set<ConstraintViolation<Car>> constraintViolations = validator.validateValue(Car.class,"licensePlate","A");

		assertThat(constraintViolations.size()).isEqualTo(1);

		printConstraintViolationMessage(constraintViolations);
	}

	private <T> void printConstraintViolationMessage(Set<ConstraintViolation<T>> constraintViolations){
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			System.out.println("message: "+constraintViolation.getMessage());
		}
	}

}
