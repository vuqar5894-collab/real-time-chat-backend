package com.vugar.chat_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeenMessage {

    private Long chatRoomId;
    private String username;

}