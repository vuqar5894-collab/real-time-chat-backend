package com.vugar.chat_app.repository;

import com.vugar.chat_app.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatRoomId(Long chatRoomId);

    @Modifying
    @Query("UPDATE Message m SET m.status='SEEN' WHERE m.chatRoom.id = :roomId")
    void markMessagesAsSeen(Long roomId);
}