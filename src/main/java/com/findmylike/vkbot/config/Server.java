package com.findmylike.vkbot.config;

import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class Server {

    private final Core core;
    private final TaskExecutor taskExecutor;
    private final MessageExecutor messageExecutor;

    @SneakyThrows
    @PostConstruct
    public void start() {
        System.out.println("Server is running...");

        while (true) {
            Thread.sleep(500);

            try {
                Message message = core.getMessage();
                if (message != null) {
                    taskExecutor.execute(messageExecutor.send(message));
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
