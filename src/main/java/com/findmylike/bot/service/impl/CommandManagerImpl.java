package com.findmylike.bot.service.impl;

import com.findmylike.bot.command.Command;
import com.findmylike.bot.service.interfaces.CommandManager;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CommandManagerImpl implements CommandManager {

    @Override
    public Set<Command> getCommandList() {
        return null;
    }

    @Override
    public void addCommand(Command command) {

    }
}
