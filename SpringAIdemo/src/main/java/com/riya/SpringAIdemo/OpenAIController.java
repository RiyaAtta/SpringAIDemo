package com.riya.SpringAIdemo;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin("*")
public class OpenAIController {

    private final OpenAiChatModel chatModel;

    public OpenAIController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response=chatModel.call(message);
        return ResponseEntity.ok(response);
    }
}
