package ru.itpark.chatfluxr2dbc.presentation.api;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itpark.chatfluxr2dbc.application.ChatService;
import ru.itpark.chatfluxr2dbc.domain.ChatMessage;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ChatMessage> getMessages() {
        return chatService.getMessages();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Mono<ChatMessage> sendMessage(@RequestBody ChatMessage message) {
        return chatService.sendMessage(message);
    }
}
