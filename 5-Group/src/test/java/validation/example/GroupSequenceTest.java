package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.example.bottle.SequenceGroup;
import validation.example.bottle.StrawberryDrinkBottleImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupSequenceTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void groupSequenceTest(){

		//================ first group ============================

		StrawberryDrinkBottleImpl strawberryDrinkBottle = new StrawberryDrinkBottleImpl(null,0);

		Set<ConstraintViolation<StrawberryDrinkBottleImpl>> constraintViolations =
				validator.validate(strawberryDrinkBottle, SequenceGroup.class);

		assertThat(constraintViolations.size()).isEqualTo(1);

		constraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));

		//================ second group ============================

		strawberryDrinkBottle = new StrawberryDrinkBottleImpl("juice",0);

		constraintViolations = validator.validate(strawberryDrinkBottle, SequenceGroup.class);

		assertThat(constraintViolations.size()).isEqualTo(1);

		constraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
	}
}
