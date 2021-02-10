package com.findmylike.vkbot.service.interfaces;

import com.findmylike.vkbot.command.Command;
import com.vk.api.sdk.objects.messages.Message;

public interface CommandParser {

    Command parse(Message message);

}
