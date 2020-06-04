package validation.example.appendix.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import validation.example.appendix.spring.StringBox;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void regist() throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();

		String requestJson = objectMapper.writeValueAsString(new StringBox(null));

		mockMvc.perform(
				post("/stringbox/regist")
						.content(requestJson)
		)
				.andDo(print())
				.andExpect(status().isBadRequest());

	}
}