package com.vugar.chat_app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {

    private Long chatRoomId;
    private String sender;
    private String content;
}