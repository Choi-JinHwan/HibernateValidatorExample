package validation.example.mouse;

import org.hibernate.validator.constraints.Range;

/**
 * 무조건 1000원 이상 있는 마법의 지갑
 */
public class MagicWallet implements Wallet {

	private Integer money;

	public MagicWallet(Integer money) {
		this.money = money;
	}

	@Override
	@Range(min = 1000)
	public Integer getMoney() {
		return money;
	}

}
