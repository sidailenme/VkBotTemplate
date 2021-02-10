package com.findmylike.vkbot.service.impl;

import com.findmylike.vkbot.config.Core;
import com.findmylike.vkbot.service.interfaces.MessageSender;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class MessageSenderImpl implements MessageSender {

    private final Core core;

    private final Random random = new Random();

    @SneakyThrows
    public void sendMessage(Message responseMessage){
        validator(responseMessage);
        core.getVk().messages().send(core.getGroupActor())
                .message(responseMessage.getText())
                .peerId(responseMessage.getPeerId())
                .keyboard(responseMessage.getKeyboard())
                .randomId(random.nextInt())
                .execute();
    }

    private void validator(Message message) {
        if (message.getKeyboard() == null) {
            message.setKeyboard(new Keyboard());
        }
        if (message.getText() == null) {
            message.setText("");
        }
    }
}
