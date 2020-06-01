package validation.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueExtractorTest {

	private Validator validator;

	@BeforeEach
	public void setUp(){
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	void valueExtractorTest() {
		StringBox stringBox = new StringBox(null);
		StringBoxWrapper stringBoxWrapper = new StringBoxWrapper(stringBox);

		Set<ConstraintViolation<StringBoxWrapper>> constraintViolations
				= validator.validate(stringBoxWrapper);

		assertThat(constraintViolations.size()).isEqualTo(1);

		constraintViolations.forEach(constraintViolation -> System.out.println(constraintViolation.getMessage()));
	}
}
