package org.github.thomasloesch.yakuzaBot;

import org.javacord.api.event.message.MessageCreateEvent;

public class SimpleCommand implements ICommand {
    private final char COMMAND_START_CHAR = '.';

    private String commandName;

    public SimpleCommand(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public boolean matchesPattern(String message) {
        String expectedValue = COMMAND_START_CHAR + commandName;
        return message.matches(expectedValue + "*");
    }

    @Override
    public void accept(MessageCreateEvent commandContext) {
        commandContext.getChannel().sendMessage("It worked!");
    }
}
