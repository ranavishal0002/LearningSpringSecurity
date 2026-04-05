package com.example.SpringSecurity;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		User user = User.builder()
				.id(4L)
				.name("Vishal Rana")
				.email("vishal@example.com")
				.password("password123")
				.build();
		
		String token = jwtService.generateAccessToken(user);
		System.out.println(token);

		Long id = jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
