package com.vugar.chat_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateChatRoomRequest {
    private String name;
    private String type;
}
