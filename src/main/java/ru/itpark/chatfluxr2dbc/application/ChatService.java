package ru.itpark.chatfluxr2dbc.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import ru.itpark.chatfluxr2dbc.domain.ChatMessage;
import ru.itpark.chatfluxr2dbc.repository.ChatMessageRepository;

import java.time.Duration;

@Service
@AllArgsConstructor
public class ChatService {
    //    private final Sinks.Many<ChatMessage> messagesSink = Sinks.many().multicast().directBestEffort();
    private final ChatMessageRepository chatMessageRepository;

    public Mono<ChatMessage> sendMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }

    public Mono<ChatMessage> getMessages() {
        return chatMessageRepository.findLastMessage();
    }
}
