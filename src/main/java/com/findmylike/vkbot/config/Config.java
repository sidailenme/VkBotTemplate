package com.findmylike.vkbot.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${vk-api.auth.groupAccessToken}") private String groupAccessToken;
    @Value("${vk-api.auth.groupId}") private int groupId;
    @Value("${vk-api.auth.userAccessToken}") private String userAccessToken;
    @Value("${vk-api.auth.userId}") private int userId;

    @Bean
    public VkApiClient vkApiClient() {
        TransportClient client = HttpTransportClient.getInstance();
        return new VkApiClient(client);
    }

    @Bean
    public GroupActor groupActor() {
        return new GroupActor(groupId, groupAccessToken);
    }

    @SneakyThrows
    @Bean
    public UserActor userActor() {
//        UserAuthResponse authResponse = vkApiClient().oAuth().userAuthorizationCodeFlow(userId, userAccessToken, "http://localhost:5556", code).execute();
//        return new UserActor(authResponse|.getUserId(), authResponse.getAccessToken());
        return new UserActor(userId, userAccessToken); //todo delete
    }
}
