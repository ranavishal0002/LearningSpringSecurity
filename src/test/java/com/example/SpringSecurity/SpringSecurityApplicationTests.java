package com.example.SpringSecurity;

import com.example.SpringSecurity.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		EmployeeEntity employeeEntity = new EmployeeEntity(
				4L,
				"Vishal",
				"Rana",
				"vishal@example.com",
				"Engineering",
				"password123"
		);
String token = jwtService.generateToken(employeeEntity);
		System.out.println(token);

		Long id = jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
