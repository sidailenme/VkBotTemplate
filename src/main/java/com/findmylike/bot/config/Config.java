package com.findmylike.bot.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final String groupAccessToken = "7dd3a1b523590401b2bcf7a2f78bd54d361c884e2a7788d863cd679569afcd06fd1b7c80c8b7fff0d5e12";
    private final int groupId = 201009728; //todo add to properties
    private final String userAccessToken = "E3U2qYshxL62UjPLdxaw";
    private final int userId = 7692396;
    private final String code = "0050459628b41450c9";

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
        UserAuthResponse authResponse = vkApiClient().oAuth().userAuthorizationCodeFlow(userId, userAccessToken, "http://localhost:5556", code).execute();
        return new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }
}
