package com.dev.opendelivery.order.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Open Delivery - Pedidos",
        version = "v1.1.0",
        description = "API de Pedidos para integração com aplicativos de entrega.",
        license = @License(
                name = "MIT License",
                url = "https://choosealicense.com/licenses/mit/"
        )
))
public class SwaggerConfig {}
