package com.findmylike.vkbot.config;

import com.findmylike.vkbot.command.Command;
import com.findmylike.vkbot.command.TextCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public Set<Command> commandSet() {
        Set<Command> commandSet = new HashSet<>();
        commandSet.add(new TextCommand("Привет", "Привет)"));

        return commandSet;
    }

}
