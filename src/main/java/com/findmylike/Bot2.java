package com.findmylike;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;

import java.util.Properties;

public class Bot2 {

    private VkApiClient vkApiClient;


    public static void main(String[] args) {
//        System.setProperty("java.util.logging.config.file", "logging.properties");
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

    }

}
