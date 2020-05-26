package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.example.person.Adult;
import validation.example.person.Person;
import validation.example.person.Teenager;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupValidationBasicTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void groupingTest(){
		Person teenager = new Person("teenager","driverLicense-01");
		Set<ConstraintViolation<Person>> teenagerConstraintViolations = validator.validate(teenager, Teenager.class);

		assertThat(teenagerConstraintViolations.size()).isEqualTo(1);

		teenagerConstraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));

		Person adult = new Person("adult", "driverLicense-02");

		Set<ConstraintViolation<Person>> adultConstraintViolations = validator.validate(adult, Adult.class);

		assertThat(adultConstraintViolations.size()).isEqualTo(0);

		adultConstraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
	}
}
