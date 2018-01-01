package net.javavatutorial.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RestControllerExample {
	
	@RequestMapping("/hellorest")
	String helloRest() {
		return("Hello World. This is produced by the rest conntroller method");
	}

	public static void main(String[] args) {
		SpringApplication.run(RestControllerExample.class, args);
	}

}
