package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.example.bottle.StrawberryDrinkBottle;
import validation.example.bottle.StrawberryDrinkBottleImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupInheritanceTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void groupInheritanceTest(){
		StrawberryDrinkBottleImpl strawberryDrinkBottle = new StrawberryDrinkBottleImpl();

		Set<ConstraintViolation<StrawberryDrinkBottleImpl>> constraintViolations =
				validator.validate(strawberryDrinkBottle, StrawberryDrinkBottle.class);

//		assertThat(constraintViolations.size()).isEqualTo(2);

		constraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
	}
}
