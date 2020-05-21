package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.example.car.Car;
import validation.example.car.CarOwner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Object Graph Test")
public class ObjectGraphConstraintTest {

	Validator validator;

	@BeforeEach
	public void setUp() {
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test @DisplayName("Object Graph")
	public void objectDriverTest(){
		Car invalidCar = new Car("A", 4);
		CarOwner carOwner = new CarOwner(invalidCar);

		Set<ConstraintViolation<CarOwner>> constraintViolations = validator.validate(carOwner);

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
