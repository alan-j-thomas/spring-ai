package com.spring.ai.demo.spring_ai.controller;

import com.spring.ai.demo.spring_ai.entity.Response;
import com.spring.ai.demo.spring_ai.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final ChatService chatService;

    public MessageController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        return ResponseEntity.ok(chatService.chatWithOptions(message));
    }
}
