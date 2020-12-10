package com.findmylike.bot.service;

import com.findmylike.bot.service.interfaces.CommandExecutor;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@RequiredArgsConstructor
public class Messenger implements Runnable {

    private final CommandExecutor commandExecutor;

    private Message message;

    @Override
    public void run() {
        commandExecutor.execute(message);
    }


    public Messenger send(Message message) {
        this.message = message;
        return this;
    }

}
