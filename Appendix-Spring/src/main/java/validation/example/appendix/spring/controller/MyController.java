package validation.example.appendix.spring.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validation.example.appendix.spring.StringBox;

@RestController
@RequestMapping("/stringbox")
public class MyController {

	@PostMapping("/regist")
	public StringBox regist(@Validated StringBox stringBox){
		return  stringBox;
	}
}
