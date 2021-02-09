//package com.findmylike.oldPackage.old.config;
//
//import com.vk.api.sdk.client.TransportClient;
//import com.vk.api.sdk.client.VkApiClient;
//import com.vk.api.sdk.client.actors.GroupActor;
//import com.vk.api.sdk.exceptions.ApiException;
//import com.vk.api.sdk.exceptions.ClientException;
//import com.vk.api.sdk.httpclient.HttpTransportClient;
//
//public class Core2 {
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
//    public Core2() throws ClientException, ApiException {
//        TransportClient client = HttpTransportClient.getInstance();
//        vk = new VkApiClient(client);
//        actor = new GroupActor(groupId, accessToken);
//        ts = vk.messages().getLongPollServer(actor).execute().getTs();
//    }
//
//    public void go() {
//    }
//
//}
