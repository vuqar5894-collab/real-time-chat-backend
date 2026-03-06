package com.vugar.chat_app.service;

import com.vugar.chat_app.entity.ChatRoom;
import com.vugar.chat_app.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom getOrCreatePrivateRoom(String user1, String user2){

        Optional<ChatRoom> room =
                chatRoomRepository.findByUser1AndUser2(user1, user2);

        if(room.isPresent()){
            return room.get();
        }

        Optional<ChatRoom> reverse =
                chatRoomRepository.findByUser1AndUser2(user2, user1);

        if(reverse.isPresent()){
            return reverse.get();
        }

        ChatRoom newRoom = ChatRoom.builder()
                .type("PRIVATE")
                .user1(user1)
                .user2(user2)
                .name(user1 + "_" + user2)
                .build();

        return chatRoomRepository.save(newRoom);
    }
}