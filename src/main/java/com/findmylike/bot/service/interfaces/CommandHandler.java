package com.findmylike.bot.service.interfaces;

import com.findmylike.bot.command.Command;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Collection;

public interface CommandHandler {

    Command getCommand(Collection<Command> commands, Message message);
}
