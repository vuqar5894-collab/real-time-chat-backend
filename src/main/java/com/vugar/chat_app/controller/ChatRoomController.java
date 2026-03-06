package com.vugar.chat_app.controller;

import com.vugar.chat_app.dto.CreateChatRoomRequest;
import com.vugar.chat_app.entity.ChatRoom;
import com.vugar.chat_app.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatrooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    @PostMapping
    public ChatRoom createRoom(@RequestBody CreateChatRoomRequest request){

        ChatRoom room = ChatRoom.builder()
                .name(request.getName())
                .type(request.getType())
                .build();

        return chatRoomRepository.save(room);
    }

}