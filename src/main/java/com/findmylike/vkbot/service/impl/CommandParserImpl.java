package com.findmylike.vkbot.service.impl;

import com.findmylike.vkbot.command.Command;
import com.findmylike.vkbot.command.UnknownCommand;
import com.findmylike.vkbot.service.interfaces.CommandParser;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommandParserImpl implements CommandParser {

    private final Set<Command> commandSet;

    @Override
    public Command parse(Message message) {
        String textMessage = message.getText();
        Optional<Command> first = commandSet.stream()
                .filter(command -> command.getCommand().equalsIgnoreCase(textMessage))
                .findFirst();
        return first.orElse(UnknownCommand.get());
    }

}
