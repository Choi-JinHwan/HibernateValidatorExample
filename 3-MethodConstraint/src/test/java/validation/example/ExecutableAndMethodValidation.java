package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.example.car.Car;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("메소드&생성자 검증")
public class ExecutableAndMethodValidation {

	private ExecutableValidator validator;

	@BeforeEach
	public void setUp() {
		this.validator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();
	}

	@Test
	@DisplayName("메소드 인자 값 검증")
	public void methodArgValueValidation() throws NoSuchMethodException {
		// Given
		Car car = new Car("A-1234");
		Method setLicensePlate = Car.class.getMethod("setLicensePlate", String.class);
		Object[] invalidParameters = {"A"};

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validateParameters(
				car,                // 객체
				setLicensePlate,    // 메소드
				invalidParameters   // 파라미터
		);

		// Then
		assertThat(constraintViolations.size()).isGreaterThan(0);

		Iterator<Path.Node> propertyPath = constraintViolations
				.iterator()
				.next()
				.getPropertyPath()
				.iterator();

		Path.MethodNode methodNode = propertyPath.next().as(Path.MethodNode.class);
		System.out.println("methodNode name: "+methodNode.getName());
		methodNode.getParameterTypes().forEach(returnType -> System.out.println("method return type: "+returnType));

		printConstraintViolations(constraintViolations);
	}

	@Test
	@DisplayName("메소드 반환 값 검증")
	public void methodReturnValueValidation() throws NoSuchMethodException {
		// Given
		Car car = new Car("A");
		Method getDrivenDistanceString = Car.class.getMethod("getDrivenDistanceString");
		String returnValue = "100 Km";

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validateReturnValue(
				car,                        // 객체
				getDrivenDistanceString,    // 메소드
				returnValue                 // 반환값
		);

		// Then
		System.out.println("return value: " + returnValue);

		assertThat(constraintViolations.size()).isGreaterThan(0);

		printConstraintViolations(constraintViolations);
	}

	@Test
	@DisplayName("생성자 인자 값 검증")
	public void constructorArgValidation() throws NoSuchMethodException {
		// Given
		Constructor<Car> constructor = Car.class.getConstructor(String.class);
		Object[] parameters = {""};

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validateConstructorParameters(
				constructor,    // 생성자
				parameters      // 인자
		);

		// Then
		assertThat(constraintViolations.size()).isGreaterThan(0);

		printConstraintViolations(constraintViolations);
	}

	@Test
	@DisplayName("생성자 반환 값 검증")
	public void constructorReturnValueValidation() throws NoSuchMethodException {
		// Given
		Car createdObject = new Car("");
		Constructor<Car> constructor = Car.class.getConstructor(String.class);

		// When
		Set<ConstraintViolation<Car>> constraintViolations = validator.validateConstructorReturnValue(
				constructor,
				createdObject
		);

		// Then
		assertThat(constraintViolations.size()).isGreaterThan(0);

		printConstraintViolations(constraintViolations);
	}


	private <T> void printConstraintViolations(Set<ConstraintViolation<T>> constraintViolations) {
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			System.out.println("제약 위반: " + constraintViolation.getMessage());
		}
	}

}