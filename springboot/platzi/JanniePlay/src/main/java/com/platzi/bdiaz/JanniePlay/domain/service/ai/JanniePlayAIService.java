package com.platzi.bdiaz.JanniePlay.domain.service.ai;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface JanniePlayAIService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestión de peliculas {{namePlataform}}.
            Usa menos de 120 caracteres y hazlo con estilo de Netflix.
            """)
    String generateGreeting(@V("namePlataform") String namePlataform);

}
