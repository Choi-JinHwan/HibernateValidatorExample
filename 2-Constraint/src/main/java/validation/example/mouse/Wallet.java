package validation.example.mouse;

import javax.validation.constraints.PositiveOrZero;

public interface Wallet {

	@PositiveOrZero
	Integer getMoney();

}
