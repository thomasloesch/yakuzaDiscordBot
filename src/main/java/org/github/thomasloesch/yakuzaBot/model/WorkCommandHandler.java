package org.github.thomasloesch.yakuzaBot.model;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.ArrayList;

public class WorkCommandHandler extends DiscordCommandHandler {
    private final String MESSAGE_MATCH_REGEX = ".*";
    private final String SUCCESS_RESULT_STRING = "You have been assigned as a: ";

    private ArrayList<String> possibleJobArr;


    public WorkCommandHandler() {
        InitializeJobArr();
    }

    private void InitializeJobArr() {
        possibleJobArr = new ArrayList<>();
        possibleJobArr.add("drug dealer");
    }

    @Override
    public HandlerResult handle(MessageCreateEvent commandContext) {
        String message = commandContext.getMessage().getContent();
        
        String jobString = message.substring(message.indexOf(' ')).toLowerCase().trim();

        if (possibleJobArr.contains(jobString)) {
            return new SuccessResult(jobString, SUCCESS_RESULT_STRING);
        }

        return new ErrorResult("Did not match expected input. Please try again.");
    }
}
