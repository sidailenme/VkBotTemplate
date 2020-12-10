package com.findmylike.bot.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final String accessToken = "7dd3a1b523590401b2bcf7a2f78bd54d361c884e2a7788d863cd679569afcd06fd1b7c80c8b7fff0d5e12";
    private final int groupId = 201009728; //todo

//    private final Server server;

    @Bean
    public VkApiClient vkApiClient() {
        TransportClient client = HttpTransportClient.getInstance();
        return new VkApiClient(client);
    }

    @Bean
    public GroupActor groupActor() {
        return new GroupActor(groupId, accessToken);
    }

//    @Bean
//    public void startServer() {
//        System.out.println("ststs");
//        server.start();
//    }
}
