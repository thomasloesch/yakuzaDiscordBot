package org.github.thomasloesch.yakuzaBot.view;

import org.github.thomasloesch.yakuzaBot.model.HandlerResult;
import org.javacord.api.event.message.MessageCreateEvent;

public abstract class DiscordCommandView {
    public abstract boolean view(MessageCreateEvent commandContext, HandlerResult result);
}
