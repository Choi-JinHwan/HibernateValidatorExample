package validation.example.car;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter @Setter
public class ParkingLot {

	/**
	 * List등 <code>java.util.Iterable</code> 객체에서도 제약 가능
	 */
	private List<@Valid Car> parkedCars;

	public ParkingLot(List<Car> parkedCars) {
		this.parkedCars = parkedCars;
	}

}
