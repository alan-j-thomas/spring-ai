package com.spring.ai.demo.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient openAiChatClient;

    private final ChatClient ollamaChatClient;

    public ChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient,
                          @Qualifier("ollamaChatClient") ChatClient ollamaChatClient){
        this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        String response = openAiChatClient.prompt(message).call().content();
        return ResponseEntity.ok(response);
    }
}
