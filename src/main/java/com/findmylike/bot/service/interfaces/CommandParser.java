package com.findmylike.bot.service.interfaces;

import com.findmylike.bot.command.Command;
import com.vk.api.sdk.objects.messages.Message;

public interface CommandParser {

    Command parse(Message message);

}
