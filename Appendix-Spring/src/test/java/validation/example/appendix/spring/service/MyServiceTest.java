package validation.example.appendix.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import validation.example.appendix.spring.StringBox;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MyServiceTest {

	@Autowired
	private MySelfService mySelfService;

	@Autowired
	private MyAutoService myAutoService;

	@Test
	public void selfService() {
		ConstraintViolationException constraintViolationException = assertThrows(ConstraintViolationException.class,
				() -> {
					mySelfService.printStringBox(new StringBox(null));
				}
		);

		constraintViolationException.getConstraintViolations().forEach(violation -> {
			System.out.println(violation.getMessage());
		});
	}

	@Test
	public void autoService() {
		ConstraintViolationException constraintViolationException = assertThrows(ConstraintViolationException.class,
				() -> {
					myAutoService.printStringBox(new StringBox(null));
				}
		);

		constraintViolationException.getConstraintViolations().forEach(violation -> {
			System.out.println(violation.getMessage());
		});

	}


}