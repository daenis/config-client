package com.example.config.api;

import com.example.config.printer.MessagePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessagePrinter messagePrinter;

    @PostMapping("/api/configuration-client/message-printing-example")
    public ResponseEntity<?> printMessage(@RequestParam("message") String message) {
        messagePrinter.printMessage(message);
        return ResponseEntity.ok().build();
    }
}
