package cl.ejerciciojava.cadenas2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Cadenas2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cadenas2Application.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hola cliente, como está?";
	}

	@RequestMapping("/random")
	public String random() {
		return "Spring Boot es genial!! Es muy fácil responder con Strings!!!";
	}
}
