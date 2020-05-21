package validation.example.car;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CarOwner {

	@Valid
	private Car car;

	public CarOwner(Car car) {
		this.car = car;
	}

	@NotNull
	public Car getCar(){
		return car;
	}

	public void setCar(Car car){
		this.car = car;
	}

}
