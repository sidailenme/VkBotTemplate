package com.vkbot.vkbot.model.command;

import com.vk.api.sdk.objects.messages.Message;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TextCommand extends Command {

    private String responseText;
    private final Message responseMessage = new Message();

    public TextCommand(String command, String responseText) {
        super(command);
        this.responseText = responseText;
    }

    @Override
    public Message execute() {
        responseMessage.setText(responseText);
        return responseMessage;
    }
}
