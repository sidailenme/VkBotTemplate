package com.findmylike.bot.service.interfaces;

import com.findmylike.bot.command.Command;

import java.util.Set;

public interface CommandManager {

    Set<Command> getCommandList();

    void addCommand(Command command);

}
