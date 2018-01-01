package net.javavatutorial.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/*")
@SpringBootApplication
public class MethodAndClassLevelAnnotations {
	
	@RequestMapping
	String login() {
		return("Login method called");
	}
	
	@GetMapping("/logout")
	String logout() {
		return("Logout method called");
	}

	public static void main(String[] args) {
		SpringApplication.run(MethodAndClassLevelAnnotations.class, args);
	}

}
