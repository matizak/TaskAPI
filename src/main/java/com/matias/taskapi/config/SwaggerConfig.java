package com.matias.taskapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("matias.zakowicz@gmail.com");
        contact.setName("Matias Alejandro Zakowicz");
        contact.setUrl("https://matizak.ar");

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8081");
        localServer.setDescription("Servidor Local");

        Server productionServer = new Server();
        productionServer.setUrl("https://my-awesome-api.com");
        productionServer.setDescription("Servidor de Producción");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API de Tareas")
                .contact(contact)
                .version("1.0")
                .description("Esta API hace backend para la app de tareas.")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer, productionServer));
    }
}
