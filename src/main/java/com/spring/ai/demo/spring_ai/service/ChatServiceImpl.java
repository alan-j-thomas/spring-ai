package com.spring.ai.demo.spring_ai.service;

import com.spring.ai.demo.spring_ai.entity.Response;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private final ChatClient chatClient;

    public ChatServiceImpl(@Qualifier("openAiChatClient") ChatClient chatClient){
        this.chatClient = chatClient;
    }

    @Override
    public Response chat(String query) {

        /*
        var response = chatClient.prompt()
                .user(query)
                .system("You are a music enthusiast!")
                .call()
                .content();

         */

        //Using custom class for storing response
        Prompt prompt = new Prompt(query);

        return chatClient.prompt(prompt)
                .call()
                .entity(Response.class);
    }
}
