package com.example.config.printer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMessagePrinter implements MessagePrinter {

    @Value("${com.example.config.config-client.name}")
    private String name;

    @Override
    public void printMessage(String message) {
        System.out.println(name + "- New Message:");
        System.out.println(message);
    }
}
