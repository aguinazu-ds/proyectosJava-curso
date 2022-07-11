package cl.ejerciciojava.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}

	@RequestMapping("/")
	public String Home() {
		return "Hola cliente, como está??";
	}

	@RequestMapping("/random")
	public String Random() {
		return "Spring Boot es genial!! Es muy fácil responder con Strings!!!";
	}
}
