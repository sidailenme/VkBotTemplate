package com.findmylike.vkbot.service.impl;

import com.findmylike.vkbot.model.command.Command;
import com.findmylike.vkbot.service.interfaces.CommandExecutor;
import com.findmylike.vkbot.service.interfaces.CommandParser;
import com.findmylike.vkbot.service.interfaces.MessageSender;
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
