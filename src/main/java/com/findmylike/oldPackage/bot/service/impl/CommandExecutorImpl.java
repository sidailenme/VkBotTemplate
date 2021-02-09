//package com.findmylike.oldPackage.bot.service.impl;
//
//import com.findmylike.oldPackage.bot.service.interfaces.CommandExecutor;
//import com.findmylike.oldPackage.bot.service.interfaces.CommandHandler;
//import com.findmylike.oldPackage.bot.service.interfaces.CommandManager;
//import com.vk.api.sdk.objects.messages.Message;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CommandExecutorImpl implements CommandExecutor {
//
//    private final CommandHandler commandHandler;
//    private final CommandManager commandManager;
//
//    @Override
//    public void execute(Message message) {
//        commandHandler.getCommand(commandManager.getCommandList(), message).exec(message);
//    }
//}
