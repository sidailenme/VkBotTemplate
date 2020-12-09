package com.findmylike.model.command;

import com.vk.api.sdk.objects.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Command {
    private final String[] name;

    public abstract void exec(Message message);
}
