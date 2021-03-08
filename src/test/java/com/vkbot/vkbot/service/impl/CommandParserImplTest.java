package com.vkbot.vkbot.service.impl;

import com.vkbot.vkbot.model.command.Command;
import com.vkbot.vkbot.service.CommandParser;
import com.vk.api.sdk.objects.messages.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
class CommandParserImplTest {

    private CommandParser commandParser;
    private Set<Command> commandSet;
    private Message message;

    @BeforeEach
    void setUp() {
        commandSet = new HashSet<>();
        commandParser = new CommandParser(commandSet);
        message = new Message();
        message.setText("test");
    }

    @Test
    void itShouldParse() {
        Command command = commandParser.parse(message);
        assertEquals("Неизвестная команда", command.getCommand());
    }
}