package validation.example.appendix.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import validation.example.appendix.spring.StringBox;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;


@Service
public class MySelfService {

	@Autowired
	private Validator validator;

	public void printStringBox(StringBox stringBox) {
		Set<ConstraintViolation<StringBox>> constraintViolations = validator.validate(stringBox);

		if (constraintViolations.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

		System.out.println("content: " + stringBox.getContent());
	}

}
