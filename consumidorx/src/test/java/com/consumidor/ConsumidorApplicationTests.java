package com.consumidor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")//Indicamos que el perfil activo es test!
public class ConsumidorApplicationTests {

	@Value("${test}")
	private String test; 

	@Test
	public void contextLoads() {
		System.out.println(test);
	}

}
