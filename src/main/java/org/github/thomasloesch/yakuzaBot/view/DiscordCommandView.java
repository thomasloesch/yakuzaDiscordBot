package org.github.thomasloesch.yakuzaBot.view;

import org.javacord.api.event.message.MessageCreateEvent;

public class DiscordCommandView {
    public boolean view(MessageCreateEvent commandContext, HandlerResult result) {
        return false;
    }
}
