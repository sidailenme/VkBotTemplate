package com.findmylike.service;

import com.findmylike.model.command.Command;
import com.findmylike.model.command.Unknown;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Collection;

public class CommandHandler {

    public static Command getCommand(Collection<Command> commands, Message message) {
        String body = message.getText();
        for (Command command : commands) {
            for (String s : command.getName()) {
                if (s.equalsIgnoreCase(body)) {
                    return command;
                }
            }
        }
        return new Unknown(new String[] {"unknown"});
    }

}
