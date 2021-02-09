//package com.findmylike.oldPackage.old.config;
//
//import com.findmylike.bot.config.Core;
//import com.findmylike.oldPackage.bot.service.Messenger;
//import com.vk.api.sdk.exceptions.ApiException;
//import com.vk.api.sdk.exceptions.ClientException;
//import com.vk.api.sdk.objects.messages.Message;
//import org.springframework.core.task.TaskExecutor;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//
//public class VkServer {
//
//    private static Core vkCore;
//    private Messenger messenger;
//    private TaskExecutor taskExecutor;
//
//    public void start() throws InterruptedException, ApiException, ClientException {
//
//        System.out.println("Server is run...");
//
//        while (true) {
//            Thread.sleep(300);
//
//            try {
//                Message message = vkCore.getMessage();
//                if (message != null) {
//                    ExecutorService exec = Executors.newCachedThreadPool();
//                    exec.execute(new Messenger(message));
//                    taskExecutor.execute(messenger.send(message));
//
//
////                    System.out.println(message.getText());
//                }
//            } catch (NullPointerException e) {
//                System.out.println("Возникли проблемы");
//                final int RECONNECT_TIME = 10000;
//                System.out.println("Повторное соединение через " + RECONNECT_TIME / 1000 + " секунд");
//                Thread.sleep(RECONNECT_TIME);
//            }
//        }
//    }
//}
