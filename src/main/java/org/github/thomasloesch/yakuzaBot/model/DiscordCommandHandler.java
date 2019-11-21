package org.github.thomasloesch.yakuzaBot.model;

import org.javacord.api.event.message.MessageCreateEvent;

public abstract class DiscordCommandHandler {
    public abstract HandlerResult handle(MessageCreateEvent commandContext);
}
