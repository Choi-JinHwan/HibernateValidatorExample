package validation.example.bottle;

import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

@Getter
public class StrawberryBottleBox {

	@NotNull(groups = Default.class)
	@Valid @ConvertGroup(from = Default.class, to = StrawberryDrinkBottle.class)
	private StrawberryDrinkBottleImpl bottle;

	public StrawberryBottleBox(StrawberryDrinkBottleImpl bottle) {
		this.bottle = bottle;
	}

}
