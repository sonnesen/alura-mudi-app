package br.com.alura.mudi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableCaching
@SpringBootApplication
public class AluraMudiAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AluraMudiAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String rawPassword = "password";
		if (args != null && args.length == 1) {
			rawPassword = args[0];
		}		
		System.out.println(passwordEncoder.encode(rawPassword));
	}

}
