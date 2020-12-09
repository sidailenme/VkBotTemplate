package com.findmylike.service;

import com.findmylike.model.command.Command;

import java.util.HashSet;

public class CommandManager {

    private static HashSet<Command> commands = new HashSet<>();

    static {
//      commands.add(new Hello(new String[] {"привет", "старт", "start", "hello"}));
    }

    public static HashSet<Command> getCommands() {
        return commands;
    }

    public static void addCommands(Command command) {
        commands.add(command);
    }
}
