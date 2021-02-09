package com.findmylike.bot.config;

import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Server {

    private final Core core;
//    private final Messenger messenger;
    private final TaskExecutor taskExecutor;

    @SneakyThrows
    @PostConstruct
    public void start() {
        System.out.println("Server is running...");

        while (true) {
            Thread.sleep(300);

            try {
                Message message = core.getMessage();
                if (message != null) {
//                    taskExecutor.execute(messenger.send(message));
                    System.out.println(message.getText());
                }
            } catch (ClientException e) {
                System.out.println("Возникли проблемы");
                final int RECONNECT_TIME = 10000;
                System.out.println("Повторное соединение через " + RECONNECT_TIME / 1000 + " секунд");
                Thread.sleep(RECONNECT_TIME);
            }
        }
    }
}
