package com.platzi.bdiaz.JanniePlay.service.ai;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface JanniePlayAIService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestión de peliculas JanniePlay.
            Usa menos de 120 caracteres y hazlo con estilo de Netflix.
            """)
    String generateGreeting();

}
