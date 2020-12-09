package com.findmylike;

import com.findmylike.config.VkServer;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws InterruptedException, ApiException, ClientException {
        SpringApplication.run(Application.class);

    }
}
