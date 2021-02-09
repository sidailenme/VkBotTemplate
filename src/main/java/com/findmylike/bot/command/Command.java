package com.findmylike.bot.command;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Command {

    private String command;


    public abstract Message execute();
}
