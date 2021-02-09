package com.findmylike.bot.service.impl;

import com.findmylike.bot.command.Command;
import com.findmylike.bot.service.interfaces.CommandExecutor;
import com.findmylike.bot.service.interfaces.CommandParser;
import com.findmylike.bot.service.interfaces.MessageSender;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandExecutorImpl implements CommandExecutor {

    private final CommandParser commandParser;
    private final MessageSender messageSender;

    @Override
    public void execute(Message requestMessage) {
        Command command = commandParser.parse(requestMessage);

        Message responseMessage = command.execute();
        responseMessage.setPeerId(requestMessage.getPeerId());

        messageSender.sendMessage(responseMessage);
    }
}
