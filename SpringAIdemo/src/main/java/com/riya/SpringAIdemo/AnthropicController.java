package com.riya.SpringAIdemo;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anthropic")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin("*")
public class AnthropicController {

    //private final AnthropicChatModel chatModel;
    private ChatClient chatClient;

    public AnthropicController(AnthropicChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response=chatClient.prompt(message).call().content();
        return ResponseEntity.ok(response);
    }
}
