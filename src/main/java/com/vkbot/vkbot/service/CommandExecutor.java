package com.vkbot.vkbot.service;

import com.vk.api.sdk.objects.messages.Message;
import com.vkbot.vkbot.model.command.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandExecutor {

    private final CommandParser commandParser;
    private final MessageSender messageSender;

    public void execute(Message requestMessage) {
        Command command = commandParser.parse(requestMessage);

        Message responseMessage = command.execute();
        responseMessage.setPeerId(requestMessage.getPeerId());

        messageSender.sendMessage(responseMessage);
    }
}
