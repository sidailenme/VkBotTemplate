package com.findmylike.config;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserXtrCounters;

public class VkManager {

    private static VkCore vkCore;

    static {
        try {
            vkCore = new VkCore();
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
        }
    }



    public static UserXtrCounters getUserInfo(int id) throws ClientException, ApiException {
        return vkCore.getVk().users().get(vkCore.getActor()).userIds(String.valueOf(id)).execute().get(0);
    }
}
