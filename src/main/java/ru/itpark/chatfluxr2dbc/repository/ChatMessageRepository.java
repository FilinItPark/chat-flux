package ru.itpark.chatfluxr2dbc.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.itpark.chatfluxr2dbc.domain.ChatMessage;

public interface ChatMessageRepository extends ReactiveCrudRepository<ChatMessage, Integer> {
    @Query("select * from chat_messages order by id desc limit 1")
    Mono<ChatMessage> findLastMessage();


}
