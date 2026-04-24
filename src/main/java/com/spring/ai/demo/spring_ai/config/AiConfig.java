package com.spring.ai.demo.spring_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean(name = "openAiChatClient")
    public ChatClient openAiChatModel(OpenAiChatModel chatModel){
        return ChatClient.builder(chatModel)
                .defaultSystem("You are a helpful and cheerful assistant. Before any query greet and give " +
                        "a good response to the user")
                .defaultOptions(OpenAiChatOptions.
                        builder()
                        .temperature(0.7)
                        .model("gpt-4o-mini")
                        .build())
                .build();
    }

    @Bean(name = "ollamaChatClient")
    public ChatClient ollamaChatModel(OllamaChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }
}
