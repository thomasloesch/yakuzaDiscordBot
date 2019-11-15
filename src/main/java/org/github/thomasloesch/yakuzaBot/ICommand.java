package org.github.thomasloesch.yakuzaBot;

import org.javacord.api.event.message.MessageCreateEvent;

public interface ICommand {
    boolean matchesPattern(String message);
    void accept(MessageCreateEvent commandContext);
}
