package com.findmylike.bot.service.impl;

import com.findmylike.bot.command.Command;
import com.vk.api.sdk.objects.messages.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class CommandParserImplTest {

    private CommandParserImpl commandParser;
    private Set<Command> commandSet;
    private Message message;

    @BeforeEach
    void setUp() {
        commandSet = new HashSet<>();
        commandParser = new CommandParserImpl(commandSet);
        message = new Message();
        message.setText("test");
    }

    @Test
    void itShouldParse() {
        Command command = commandParser.parse(message);
        assertEquals("Неизвестная команда", command.getCommand());
    }
}