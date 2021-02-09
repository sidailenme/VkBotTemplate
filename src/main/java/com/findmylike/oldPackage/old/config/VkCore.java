//package com.findmylike.oldPackage.old.config;
//
//import com.vk.api.sdk.client.TransportClient;
//import com.vk.api.sdk.client.VkApiClient;
//import com.vk.api.sdk.client.actors.GroupActor;
//import com.vk.api.sdk.exceptions.ApiException;
//import com.vk.api.sdk.exceptions.ClientException;
//import com.vk.api.sdk.httpclient.HttpTransportClient;
//import com.vk.api.sdk.objects.messages.Message;
//import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//public class VkCore {
//    private static final String accessToken = "7dd3a1b523590401b2bcf7a2f78bd54d361c884e2a7788d863cd679569afcd06fd1b7c80c8b7fff0d5e12";
//    private static final int groupId = 201009728;
//
//    private VkApiClient vk;
//    private GroupActor actor;
//
//    private static int ts;
//    private static int maxMsgId = -1;
//
//
//    public VkCore() throws ClientException, ApiException {
//        TransportClient client = HttpTransportClient.getInstance();
//        vk = new VkApiClient(client);
//        actor = new GroupActor(groupId, accessToken);
//        ts = vk.messages().getLongPollServer(actor).execute().getTs();
//    }
//
//    public Message getMessage() throws ClientException, ApiException {
//        MessagesGetLongPollHistoryQuery eventsQuery = vk.messages().getLongPollHistory(actor).ts(ts);
//        if (maxMsgId > 0) {
//            eventsQuery.maxMsgId(maxMsgId);
//        }
//
//        List<Message> messages = eventsQuery.execute().getMessages().getItems();
//        if (!messages.isEmpty()) {
//            ts = vk.messages().getLongPollServer(actor).execute().getTs();
//        }
//
//        if (!messages.isEmpty() && !messages.get(0).isOut()) {
//            int messageId = messages.get(0).getId();
//            if (messageId > maxMsgId) {
//                maxMsgId = messageId;
//            }
//            return messages.get(0);
//        }
//        return null;
//    }
//}
