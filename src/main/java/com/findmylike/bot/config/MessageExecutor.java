package com.findmylike.bot.config;

import com.findmylike.bot.service.interfaces.MessageSender;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@RequiredArgsConstructor
public class MessageExecutor implements Runnable {

    private final MessageSender messageSender;

    private Message message;

    @Override
    public void run() {
        System.out.println(">>>> MESSAGE: " + message.getText());
        System.out.println(message);
        messageSender.sendMessage("hello", 166441826);
//        commandExecutor.execute(message);
    }

    public MessageExecutor send(Message message) {
        this.message = message;
        return this;
    }
}
