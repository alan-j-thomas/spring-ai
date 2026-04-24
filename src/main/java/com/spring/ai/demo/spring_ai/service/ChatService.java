package com.spring.ai.demo.spring_ai.service;

import com.spring.ai.demo.spring_ai.entity.Response;

public interface ChatService {

    Response chat(String query);
    String chatWithOptions(String query);
}
