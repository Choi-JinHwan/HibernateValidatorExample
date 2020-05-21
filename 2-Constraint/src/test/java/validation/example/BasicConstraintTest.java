package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.example.car.Car;
import validation.example.car.ParkingLot;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Basic Constraint Test")
public class BasicConstraintTest {

	Validator validator;

	@BeforeEach
	public void setValidator() {
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	@DisplayName("bean-constraint")
	public void beanConstraintTest() {
		// Given
		Car car = new Car("A", 4);

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

		// Then
		assertThat(constraintViolations.size()).isEqualTo(2);

		printConstraintViolations(constraintViolations);
	}

	@Test
	@DisplayName("container-element-constraint")
	public void containerElementConstraint() {
		// Given
		Car car = new Car("A", 4);
		ParkingLot parkingLot = new ParkingLot(Arrays.asList(car));
		// When
		Set<ConstraintViolation<ParkingLot>> constraintViolations = validator.validate(parkingLot);

		// Then
		assertThat(constraintViolations.size()).isEqualTo(2);

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
