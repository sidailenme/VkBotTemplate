package com.findmylike.vkbot.config;

import com.findmylike.vkbot.service.interfaces.CommandExecutor;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@RequiredArgsConstructor
public class MessageExecutor implements Runnable {

    private final CommandExecutor commandExecutor;

    private Message message;

    @Override
    public void run() {
        System.out.println(">>>> MESSAGE: " + message.getText());
        System.out.println(message); //todo delete

        commandExecutor.execute(message);
    }

    public MessageExecutor send(Message requestMessage) {
        this.message = requestMessage;
        return this;
    }
}
