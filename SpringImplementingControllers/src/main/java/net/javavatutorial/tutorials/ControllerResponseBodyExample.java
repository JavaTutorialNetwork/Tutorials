package net.javavatutorial.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class ControllerResponseBodyExample {
	
	@RequestMapping("/helloresponsebody")
	@ResponseBody
	String helloResponseBody() {
		return("Hello World. This is produced by a method annotated with ResponseBody");
	}

	public static void main(String[] args) {
		SpringApplication.run(ControllerResponseBodyExample.class, args);
	}

}