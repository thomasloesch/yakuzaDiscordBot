package org.github.thomasloesch.yakuzaBot.view;

import org.github.thomasloesch.yakuzaBot.model.HandlerResult;
import org.javacord.api.event.message.MessageCreateEvent;

public class AccountCommandViewer extends DiscordCommandView {
    @Override
    public boolean view(MessageCreateEvent commandContext, HandlerResult result) {
        commandContext.getChannel().sendMessage(result.getResultString());

        return true;
    }
}
