package validation.example;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
public class Car {

	@NotEmpty( message = "자동차의 번호판은 비어있으면 안됩니다.")
	@Length(min = 4, max = 14, message = "자동차의 번호판은 {min}~{max}글자 사이여야합니다. 현재는 ${validatedValue == null ? 0 : validatedValue.length()}자 입니다.")
	private String licensePlate;

	public Car(String licensePlate) {
		this.licensePlate = licensePlate;
	}
}
