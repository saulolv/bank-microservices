package com.study.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
 Caso seja preciso criar packags fora do padrão do submain da aplicação, é necessário adicionar a anotação @ComponentScan
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(
				title = "Accounts microservice REST API Documentation",
				version = "1.0",
				description = "EzBank accounts microservice REST API documentation",
				contact = @Contact(
						name = "EzBank"
				),
				license = @io.swagger.v3.oas.annotations.info.License()
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
