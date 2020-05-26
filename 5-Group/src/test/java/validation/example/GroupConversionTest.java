package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.example.bottle.StrawberryBottleBox;
import validation.example.bottle.StrawberryDrinkBottleImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

public class GroupConversionTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void groupConversionTest(){
		StrawberryDrinkBottleImpl juice = new StrawberryDrinkBottleImpl("juice",-10);
		StrawberryBottleBox strawberryBottleBox = new StrawberryBottleBox(juice);

		Set<ConstraintViolation<StrawberryBottleBox>> constraintViolations =
				validator.validate(strawberryBottleBox, Default.class);

		constraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));

	}
}
