package validation.example.bottle;

import javax.validation.GroupSequence;

@GroupSequence({Bottle.class, StrawberryDrinkBottle.class})
public interface SequenceGroup { }
