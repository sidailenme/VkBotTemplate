package com.findmylike.vkbot.command;

import com.vk.api.sdk.objects.messages.Message;

public class UnknownCommand extends Command {

    private static UnknownCommand unknownCommand;

    private UnknownCommand(String textCommand) {
        super(textCommand);
    }

    @Override
    public Message execute() {
        Message responseMessage = new Message();
        responseMessage.setText("Неизвестная команда");
        return responseMessage;
    }

    public static UnknownCommand get() {
        if (unknownCommand == null) {
            unknownCommand = new UnknownCommand("Неизвестная команда");
        }
        return unknownCommand;
    }

}
