package es.cafeteru.apicalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiCalculatorApplicationTests {

	@Test
	void contextLoads() {
		ApiCalculatorApplication.main(new String[] {"test1", "test2"});
		Assertions.assertTrue(true);
	}


}
