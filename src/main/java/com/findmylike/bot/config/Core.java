package com.findmylike.bot.config;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
public class Core {

    private final VkApiClient vk;
    private final GroupActor groupActor;
    private final UserActor userActor;

    private int ts;
    private int maxMsgId = -1;

    @SneakyThrows
    @PostConstruct
    private void init() {
        ts = vk.messages().getLongPollServer(groupActor).execute().getTs();
//        GetResponse execute = vk.wall().get(userActor).ownerId(166441826).count(1).execute();
//        System.out.println(execute);
    }

    public Message getMessage() throws ClientException, ApiException {
        MessagesGetLongPollHistoryQuery eventsQuery = vk.messages().getLongPollHistory(groupActor).ts(ts);
        if (maxMsgId > 0) {
            eventsQuery.maxMsgId(maxMsgId);
        }

        List<Message> messages = eventsQuery.execute().getMessages().getItems();
        if (!messages.isEmpty()) {
            ts = vk.messages().getLongPollServer(groupActor).execute().getTs();
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