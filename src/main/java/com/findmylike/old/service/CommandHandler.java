//package com.findmylike.old.service;
//
//import com.findmylike.old.command.Command;
//import com.findmylike.old.command.Unknown;
//import com.vk.api.sdk.objects.messages.Message;
//
//import java.util.Collection;
//
//public class CommandHandler {
//
//    public static Command getCommand(Collection<Command> commands, Message message) {
//        String body = message.getText();
//        for (Command command : commands) {
//            for (String s : command.getName()) {
//                if (s.equalsIgnoreCase(body)) {
//                    return command;
//                }
//            }
//        }
//        return new Unknown(new String[] {"unknown"});
//    }
//
//}
