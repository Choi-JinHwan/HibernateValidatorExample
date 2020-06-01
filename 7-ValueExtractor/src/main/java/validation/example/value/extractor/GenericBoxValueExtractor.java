package validation.example.value.extractor;

import validation.example.GenericBox;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

public class GenericBoxValueExtractor implements ValueExtractor<GenericBox<@ExtractedValue ?>> {
	@Override
	public void extractValues(GenericBox<?> originalValue, ValueReceiver receiver) {
		receiver.value(null, originalValue.getContent());
	}
}
