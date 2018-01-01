package net.javavatutorial.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class ControllerExampleJSP {
	
	@RequestMapping("/hellojsp")
	String helloJSP() {
		return("index");
	}

	public static void main(String[] args) {
		SpringApplication.run(ControllerExampleJSP.class, args);
	}
}
