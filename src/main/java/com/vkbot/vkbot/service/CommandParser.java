package com.vkbot.vkbot.service;

import com.vk.api.sdk.objects.messages.Message;
import com.vkbot.vkbot.model.command.Command;
import com.vkbot.vkbot.model.command.UnknownCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommandParser {

    private final Set<Command> commandSet;

    public Command parse(Message message) {
        String textMessage = message.getText();
        return commandSet.stream()
                .filter(command -> command.getCommand().equalsIgnoreCase(textMessage))
                .findFirst().orElse(UnknownCommand.get());
    }

}
