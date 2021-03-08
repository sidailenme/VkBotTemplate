package com.vkbot.vkbot.config;

import com.vkbot.vkbot.model.command.Command;
import com.vkbot.vkbot.model.command.TextCommand;
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
