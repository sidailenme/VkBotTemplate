package com.findmylike.service;

import com.vk.api.sdk.objects.messages.Message;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Messenger implements Runnable {

    private Message message;


    @Override
    public void run() {
        Commander.execute(message);
    }
}
