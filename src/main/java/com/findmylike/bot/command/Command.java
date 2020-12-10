package com.findmylike.bot.command;

import com.vk.api.sdk.objects.messages.Message;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Command {

    private final String name;

    public abstract void exec(Message message);
}
