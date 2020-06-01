package validation.example;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.valueextraction.Unwrapping;

public class StringBoxWrapper {

	@NotNull(payload = Unwrapping.Skip.class)
	@NotNull(payload = Unwrapping.Unwrap.class)
	private StringBox stringBox;

	public StringBoxWrapper(StringBox stringBox) {
		this.stringBox = stringBox;
	}

	public StringBox getStringBox() {
		return stringBox;
	}

	public void setStringBox(StringBox stringBox) {
		this.stringBox = stringBox;
	}
}
