package validation.example.car;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class Car {

	@NotNull
	@Size(min = 2, max = 14)
	private String licensePlate;


	@Range(min = 4, max = 8)
	private int seatCount;

	public Car(String licensePlate, int seatCount) {
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
	}

}
