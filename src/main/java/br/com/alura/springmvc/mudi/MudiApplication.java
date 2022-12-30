package br.com.alura.springmvc.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}

}
