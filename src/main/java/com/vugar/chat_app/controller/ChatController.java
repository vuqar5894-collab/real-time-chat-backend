package com.vugar.chat_app.controller;

import com.vugar.chat_app.dto.ChatMessage;
import com.vugar.chat_app.dto.SeenMessage;
import com.vugar.chat_app.dto.TypingMessage;
import com.vugar.chat_app.entity.ChatRoom;
import com.vugar.chat_app.entity.Message;
import com.vugar.chat_app.entity.MessageStatus;
import com.vugar.chat_app.repository.ChatRoomRepository;
import com.vugar.chat_app.service.MessageService;
import com.vugar.chat_app.service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;
    private final ChatRoomRepository chatRoomRepository;
    private final RedisPublisher redisPublisher;

    @MessageMapping("/chat.send")
    public void sendMessage(ChatMessage chatMessage){

        ChatRoom room = chatRoomRepository
                .findById(chatMessage.getChatRoomId())
                .orElseThrow();

        Message message = Message.builder()
                .content(chatMessage.getContent())
                .sender(chatMessage.getSender())
                .chatRoom(room)
                .status(MessageStatus.SENT)
                .build();

        messageService.saveMessage(message);

        redisPublisher.publish(chatMessage);

    }
    @MessageMapping("/chat.typing")
    public void typing(TypingMessage message){

        messagingTemplate.convertAndSend(
                "/topic/typing/" + message.getChatRoomId(),
                message
        );
    }
    @MessageMapping("/chat.seen")
    public void seen(SeenMessage message){

        messageService.markAsSeen(message.getChatRoomId());

        messagingTemplate.convertAndSend(
                "/topic/seen/" + message.getChatRoomId(),
                message
        );
    }
}