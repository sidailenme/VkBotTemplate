package com.vkbot.vkbot.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${vk-api.auth.groupAccessToken}") private String groupAccessToken;
    @Value("${vk-api.auth.groupId}") private int groupId;

    @Bean
    public VkApiClient vkApiClient() {
        TransportClient client = HttpTransportClient.getInstance();
        return new VkApiClient(client);
    }

    @Bean
    public GroupActor groupActor() {
        return new GroupActor(groupId, groupAccessToken);
    }
}
