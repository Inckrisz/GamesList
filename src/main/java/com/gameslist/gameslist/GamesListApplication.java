package com.gameslist.gameslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class GamesListApplication {

	public static void main(String[] args) {

		SpringApplication.run(GamesListApplication.class, args);
	}

//	@GetMapping("/root")
//	public String apiRoot() {
//		return "Hello World";
//	}
}
