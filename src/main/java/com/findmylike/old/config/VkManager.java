//package com.findmylike.old.config;
//
//import com.vk.api.sdk.exceptions.ApiException;
//import com.vk.api.sdk.exceptions.ClientException;
//import com.vk.api.sdk.objects.users.responses.GetResponse;
//
//import java.util.Random;
//
//public class VkManager {
//
//    private static VkCore vkCore;
//    private static Random random = new Random();
//
//    static {
//        try {
//            vkCore = new VkCore();
//        } catch (ClientException | ApiException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendMessage(String msg, int peerId){
//        if (msg == null){
//            System.out.println("null");
//            return;
//        }
//        try {
//            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(msg).randomId(random.nextInt()).execute();
//        } catch (ApiException | ClientException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public static GetResponse getUserInfo(int id) throws ClientException, ApiException {
//        return vkCore.getVk().users().get(vkCore.getActor()).userIds(String.valueOf(id)).execute().get(0);
//    }
//}
