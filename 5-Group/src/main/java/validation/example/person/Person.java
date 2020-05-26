package validation.example.person;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

@Getter
public class Person {

	@NotNull
	private String name;

	@Null(groups = {Teenager.class, Default.class})
	private String driverLicense;

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, String driverLicense) {
		this.name = name;
		this.driverLicense = driverLicense;
	}
}
