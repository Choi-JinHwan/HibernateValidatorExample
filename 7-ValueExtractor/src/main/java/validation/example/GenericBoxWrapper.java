package validation.example;

import validation.example.GenericBox;

import javax.validation.constraints.NotNull;
import javax.validation.valueextraction.Unwrapping;

public class GenericBoxWrapper {

	@NotNull(payload = Unwrapping.Skip.class)
	@NotNull(payload = Unwrapping.Unwrap.class)
	private GenericBox<String> box;

	public GenericBoxWrapper(GenericBox<String> box) {
		this.box = box;
	}

	public GenericBox<String> getBox() {
		return box;
	}

	public void setBox(GenericBox<String> box) {
		this.box = box;
	}
}
