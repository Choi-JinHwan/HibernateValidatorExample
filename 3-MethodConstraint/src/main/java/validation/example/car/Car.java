package validation.example.car;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Getter
public class Car {

	@Length(min = 4, max = 14)
	private String licensePlate;

	@PositiveOrZero
	private int drivenDistance;

	@Valid
	public Car(
			@Length(min = 4, max = 14)
					String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Length(min = 4, max = 14)
	public String getLicensePlate(){
		return licensePlate;
	}

	public void setLicensePlate(@Length(min = 4, max = 14)
			                            String licensePlate) {
		System.out.println("setLicensePlate(\""+licensePlate+"\")");
		this.licensePlate = licensePlate;
	}

	@Pattern(regexp = "\\d+ M")
	public String getDrivenDistanceString() {
		return drivenDistance+" Km";
	}
}
