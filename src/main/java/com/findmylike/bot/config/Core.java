package com.findmylike.bot.config;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class Core {

    private final VkApiClient vk;
    private final GroupActor actor;

    private int ts;
    private int maxMsgId = -1;

    @SneakyThrows
    @PostConstruct
    private void init() {
        ts = vk.messages().getLongPollServer(actor).execute().getTs();
    }

    public Message getMessage() throws ClientException, ApiException {
        MessagesGetLongPollHistoryQuery eventsQuery = vk.messages().getLongPollHistory(actor).ts(ts);
        if (maxMsgId > 0) {
            eventsQuery.maxMsgId(maxMsgId);
        }

        List<Message> messages = eventsQuery.execute().getMessages().getItems();
        if (!messages.isEmpty()) {
            ts = vk.messages().getLongPollServer(actor).execute().getTs();
        }

        if (!messages.isEmpty() && !messages.get(0).isOut()) {
            int messageId = messages.get(0).getId();
            if (messageId > maxMsgId) {
                maxMsgId = messageId;
            }
            return messages.get(0);
        }
        return null;
    }

}