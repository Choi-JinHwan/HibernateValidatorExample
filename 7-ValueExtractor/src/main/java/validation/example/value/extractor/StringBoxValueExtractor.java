package validation.example.value.extractor;

import validation.example.StringBox;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.UnwrapByDefault;
import javax.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class StringBoxValueExtractor implements ValueExtractor<@ExtractedValue(type = String.class) StringBox> {

	@Override
	public void extractValues(StringBox originalValue, ValueReceiver receiver) {
		receiver.value(null, originalValue.getContent());
	}

}
