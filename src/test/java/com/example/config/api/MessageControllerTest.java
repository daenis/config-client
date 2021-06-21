package com.example.config.api;

import com.example.config.printer.MessagePrinter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    private String theMessage;

    @Mock
    private MessagePrinter messagePrinter;

    private MessageController messageController;

    @Test
    void init() {
        theMessage = "Are you finished those errands?";

        messageController = new MessageController(messagePrinter);
    }

    @Test
    void shouldPrintTheMessage() {
        messageController.printMessage(theMessage);

        verify(messagePrinter, times(1)).printMessage(theMessage);
    }

    @Test
    void shouldReturnAnOkResponse() {
        ResponseEntity<?> anOkResponse = ResponseEntity.ok().build();

        ResponseEntity<?> theReturnedResponse = messageController.printMessage(theMessage);

        assertThat(theReturnedResponse).isEqualTo(anOkResponse);
    }
}