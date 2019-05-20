package com.esteban.testingPOC;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories // Es importante ubicar esta anotacion en un archivo separado del main, porque si la definis en el mismo archivo que tiene el main, esta anotacion va a disparar la creacion de los beans @Repository y por ende para los test en el caso cuando probas las web layer no queres que se ejecute esta anotacion
public class AppConfig {
}
