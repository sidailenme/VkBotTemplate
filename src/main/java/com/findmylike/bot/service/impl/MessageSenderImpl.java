package com.findmylike.bot.service.impl;

import com.findmylike.bot.config.Core;
import com.findmylike.bot.service.interfaces.MessageSender;
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
        core.getVk().messages().send(core.getActor())
                .message(responseMessage.getText())
                .peerId(166441826)
                .keyboard(responseMessage.getKeyboard())
                .randomId(random.nextInt())
                .execute();
    }
}
