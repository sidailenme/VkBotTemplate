package com.findmylike.config;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public void go() throws InterruptedException, ApiException, ClientException {
        VkServer vkServer = new VkServer();
        vkServer.start();
    }
}
