package io.kodido.templates.reactive.spring.admin.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( {
        "<controllers>",
        "<services>"
} )
public class AppConfig {
}
