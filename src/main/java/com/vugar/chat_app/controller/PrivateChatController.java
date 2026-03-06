package com.vugar.chat_app.controller;

import com.vugar.chat_app.entity.ChatRoom;
import com.vugar.chat_app.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/private-chat")
@RequiredArgsConstructor
public class PrivateChatController {

    private final ChatRoomService chatRoomService;

    @PostMapping
    public ChatRoom createPrivateChat(
            @RequestParam String user1,
            @RequestParam String user2
    ){
        return chatRoomService.getOrCreatePrivateRoom(user1, user2);
    }
}