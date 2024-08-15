package ru.itpark.chatfluxr2dbc.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("chat_messages")
public class ChatMessage {
    @Id
    private Integer id;

    private String text;
    private String author;
}
