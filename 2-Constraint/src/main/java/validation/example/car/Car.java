package validation.example.car;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

@Getter
public class Car {

	@NotNull
	@Size(min = 2, max = 14)
	private String licensePlate;

	@Range(min = 4, max = 8)
	private int seatCount;

	private String driverName;

	public Car(String licensePlate, int seatCount) {
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
	}

	@NotEmpty
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
}
