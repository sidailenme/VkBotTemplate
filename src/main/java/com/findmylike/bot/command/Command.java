package com.findmylike.bot.command;

import com.vk.api.sdk.objects.messages.Message;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Command {

    private final String name;

    public abstract void execute(Message message);
}
