package com.vugar.chat_app.controller;

import com.vugar.chat_app.entity.Message;
import com.vugar.chat_app.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    @GetMapping("/{chatRoomId}")
    public List<Message> getMessages(@PathVariable Long chatRoomId) {
        return messageRepository.findByChatRoomId(chatRoomId);
    }
}