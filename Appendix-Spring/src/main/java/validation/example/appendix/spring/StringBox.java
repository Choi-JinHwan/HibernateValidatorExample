package validation.example.appendix.spring;

import lombok.Getter;
import validation.example.appendix.spring.constraint.CustomConstraint;

import javax.validation.constraints.NotBlank;


@Getter
@CustomConstraint
public class StringBox {

	private String content;

	public StringBox(String content) {
		this.content = content;
	}
}
