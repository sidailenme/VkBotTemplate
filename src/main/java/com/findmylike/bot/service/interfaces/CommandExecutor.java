package com.findmylike.bot.service.interfaces;

import com.vk.api.sdk.objects.messages.Message;

public interface CommandExecutor {

    void execute(Message message);
}
