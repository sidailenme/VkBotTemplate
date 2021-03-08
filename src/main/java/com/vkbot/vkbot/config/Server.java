package com.vkbot.vkbot.config;

import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${vk-api.config.reconnectTime}") private int reconnectTime;

    @SneakyThrows
    @PostConstruct
    public void start() {
        System.out.println("Server is running...");

        while (true) {
            Thread.sleep(500);

            try {
                Message message = core.getMessage();
                if (message != null) {
                    taskExecutor.execute(messageExecutor.execute(message));
                }
            } catch (ClientException e) {
                log.warn("Повторное соединение через " + reconnectTime / 1000 + " секунд");
                Thread.sleep(reconnectTime);
            }
        }
    }
}
