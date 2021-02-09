package com.findmylike.bot.service.impl;

import com.findmylike.bot.config.Core;
import com.findmylike.bot.service.interfaces.MessageSender;
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
    public void sendMessage(String message, int peerId){
        if (message.isEmpty()) {
            throw new IllegalStateException("Message may not be null");
        }
            core.getVk().messages().send(core.getActor())
                    .peerId(peerId)
                    .message(message)
                    .randomId(random.nextInt())
                    .execute();
    }
}
