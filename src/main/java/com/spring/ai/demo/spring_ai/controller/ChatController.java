package com.spring.ai.demo.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient openAiChatClient;

    private final ChatClient ollamaChatClient;

    public ChatController(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel){
        this.openAiChatClient = ChatClient.builder(openAiChatModel).build();
        this.ollamaChatClient = ChatClient.builder(ollamaChatModel).build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        String response = openAiChatClient.prompt(message).call().content();
        return ResponseEntity.ok(response);
    }
}
