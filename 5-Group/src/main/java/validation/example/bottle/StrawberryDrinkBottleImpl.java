package validation.example.bottle;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Getter
public class StrawberryDrinkBottleImpl {

	@NotNull(groups = Bottle.class)
	private String drinkName;

	@Range(min = 1, max = 8, groups = StrawberryDrinkBottle.class)
	private Integer strawBerryCount;

	public StrawberryDrinkBottleImpl(){}

	public StrawberryDrinkBottleImpl(String drinkName) {
		this.drinkName = drinkName;
	}

	public StrawberryDrinkBottleImpl( String drinkName, int strawBerryCount) {
		this.drinkName = drinkName;
		this.strawBerryCount = strawBerryCount;
	}
}
