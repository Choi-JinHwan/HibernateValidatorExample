package validation.example.appendix.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import validation.example.appendix.spring.StringBox;
import validation.example.appendix.spring.constraint.CustomConstraint;

@Service
@Validated
public class MyAutoService {

	public void printStringBox(@CustomConstraint StringBox stringBox) {
		System.out.println("content: " + stringBox.getContent());
	}

}
