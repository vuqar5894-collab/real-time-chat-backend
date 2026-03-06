package com.vugar.chat_app.service;

import com.vugar.chat_app.entity.Message;
import com.vugar.chat_app.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }
    @Transactional
    public void markAsSeen(Long roomId){
        messageRepository.markMessagesAsSeen(roomId);
    }
}