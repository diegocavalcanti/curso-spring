package br.jus.tjms.alvara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class AlvaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlvaraApplication.class, args);
	}

}
