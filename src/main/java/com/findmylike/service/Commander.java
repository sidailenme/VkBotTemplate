package com.findmylike.service;

import com.vk.api.sdk.objects.messages.Message;

public class Commander {

    public static void execute(Message message) {
        CommandHandler.getCommand(CommandManager.getCommands(), message).exec(message);
    }

}
