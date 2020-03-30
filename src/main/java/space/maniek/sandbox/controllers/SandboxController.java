package space.maniek.sandbox.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SandboxController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}