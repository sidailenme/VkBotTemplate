package com.findmylike.bot.service.impl;

import com.findmylike.bot.service.interfaces.CommandExecutor;
import com.vk.api.sdk.objects.messages.Message;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void execute(Message message) {
        // выполняем действие, в зависимости от сообщения


    }
}
