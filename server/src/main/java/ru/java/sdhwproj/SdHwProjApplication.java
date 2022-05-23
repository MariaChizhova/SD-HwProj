package ru.java.sdhwproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SdHwProjApplication {

	/**
	 * Start server
	 * @param args (unnecessary)
	 */
	public static void main(String[] args) {
		SpringApplication.run(SdHwProjApplication.class, args);
	}

	/**
	 * Configures CORS rules for web application
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/hwproj/**");
			}
		};
	}

}
