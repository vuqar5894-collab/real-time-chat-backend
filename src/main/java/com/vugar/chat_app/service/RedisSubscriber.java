package com.vugar.chat_app.service;

import com.vugar.chat_app.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisSubscriber {

    private final SimpMessagingTemplate messagingTemplate;

    public void receiveMessage(ChatMessage message) {

        messagingTemplate.convertAndSend(
                "/topic/chat/" + message.getChatRoomId(),
                message
        );
    }
}