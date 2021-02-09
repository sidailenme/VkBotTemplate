package com.findmylike.bot.config;

import com.findmylike.bot.command.Command;
import com.findmylike.bot.command.TextCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public Set<Command> commandSet() {
        Set<Command> commandSet = new HashSet<>();
        commandSet.add(new TextCommand());


        return commandSet;
    }

}