package ru.java.sdhwproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SdHwProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdHwProjApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/hwproj/homework").allowedOrigins("http://localhost:8080");
				registry.addMapping("/hwproj/submission/{homeworkId}").allowedOrigins("http://localhost:8080");
				registry.addMapping("/hwproj/homework/{id}").allowedOrigins("http://localhost:8080");
				registry.addMapping("/hwproj/submission/{homeworkId}/{id}").allowedOrigins("http://localhost:8080");
				registry.addMapping("/hwproj/submission/add").allowedOrigins("http://localhost:8080");
				registry.addMapping("/hwproj/homework/add").allowedOrigins("http://localhost:8080");
			}
		};
	}

}
