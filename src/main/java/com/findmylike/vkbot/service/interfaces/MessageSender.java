package com.findmylike.vkbot.service.interfaces;

import com.vk.api.sdk.objects.messages.Message;

public interface MessageSender {

    void sendMessage(Message responseMessage);

}
