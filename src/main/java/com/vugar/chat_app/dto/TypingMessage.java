package com.vugar.chat_app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypingMessage {

    private Long chatRoomId;
    private String username;
    private boolean typing;
}