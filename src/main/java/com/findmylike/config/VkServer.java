package com.findmylike.config;

import com.findmylike.service.Messenger;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VkServer {

    private static VkCore vkCore;

    public void start() throws InterruptedException, ApiException, ClientException {

        vkCore = new VkCore();
        System.out.println("Server is run...");

        while (true) {
            Thread.sleep(300);

            try {
                Message message = vkCore.getMessage();
                if (message != null) {
                    ExecutorService exec = Executors.newCachedThreadPool();
                    exec.execute(new Messenger(message));
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
