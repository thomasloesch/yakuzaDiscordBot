package org.github.thomasloesch.yakuzaBot;

import org.github.thomasloesch.yakuzaBot.model.DiscordCommandHandler;
import org.github.thomasloesch.yakuzaBot.view.DiscordCommandView;
import org.github.thomasloesch.yakuzaBot.model.HandlerResult;
import org.javacord.api.event.message.MessageCreateEvent;

public class SimpleCommand implements ICommand {
    private final char COMMAND_START_CHAR = '.';

    private String commandName;
    private DiscordCommandHandler commandHandler;
    private DiscordCommandView commandViewer;

    public SimpleCommand(String commandName, DiscordCommandHandler commandHandler, DiscordCommandView commandViewer) {
        this.commandName = commandName;
        this.commandHandler = commandHandler;
        this.commandViewer = commandViewer;
    }

    @Override
    public boolean matchesPattern(String message) {
        String expectedValue = COMMAND_START_CHAR + commandName;
        return message.matches(expectedValue + ".*");
    }

    @Override
    public void accept(MessageCreateEvent commandContext) {
        HandlerResult result = commandHandler.handle(commandContext);
        commandViewer.view(commandContext, result);
    }
}
