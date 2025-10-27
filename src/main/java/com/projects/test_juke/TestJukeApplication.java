package com.projects.test_juke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.projects.test_juke.repository")
public class TestJukeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJukeApplication.class, args);
	}

}
