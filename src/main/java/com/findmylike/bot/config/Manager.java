package com.findmylike.bot.config;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class Manager {

    private final Core core;

    private Random random = new Random();


    @SneakyThrows
    public void sendMessage(String msg, int peerId){
        if (msg == null){
            System.out.println("null");
        } else {
            core.getVk().messages().send(core.getActor())
                    .peerId(peerId).message(msg)
                    .randomId(random.nextInt()).execute();
        }
    }
}
