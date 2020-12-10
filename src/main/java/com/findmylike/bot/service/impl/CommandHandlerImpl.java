package com.findmylike.bot.service.impl;

import com.findmylike.bot.command.Command;
import com.findmylike.bot.command.Unknown;
import com.findmylike.bot.service.interfaces.CommandHandler;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CommandHandlerImpl implements CommandHandler {

    private final Unknown unknownCommand = new Unknown("unknown");

    @Override
    public Command getCommand(Collection<Command> commands, Message message) {
        String body = message.getText();
        for (Command command : commands) {
            if (body.equalsIgnoreCase(command.getName())) {
                return command;
            }
        }
        return unknownCommand;
    }
}
