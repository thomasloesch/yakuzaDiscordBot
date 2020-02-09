package org.github.thomasloesch.yakuzaBot.model;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;
import java.util.ArrayList;

public class WorkCommandHandler extends DiscordCommandHandler {
    private final String MESSAGE_MATCH_REGEX = ".*";
    private final String SUCCESS_RESULT_FORMAT = "You have been assigned as a: %s";

    private ArrayList<String> possibleJobArr;
    private IUserRepository userRepository;

    public WorkCommandHandler() {
        InitializeJobArr();
        userRepository = RepositoryFactory.getRepositoryInstance();
    }

    private void InitializeJobArr() {
        possibleJobArr = new ArrayList<>();
        possibleJobArr.add("drug dealer");
        possibleJobArr.add("hitman");
        possibleJobArr.add("bouncer");
    }

    @Override
    public HandlerResult handle(MessageCreateEvent commandContext) {
        String message = commandContext.getMessage().getContent();
        
        String jobString = message.substring(message.indexOf(' ')).toLowerCase().trim();

        long userId = commandContext.getMessage().getUserAuthor().get().getId();

        if (possibleJobArr.contains(jobString)) {
            if(userRepository.getUser(userId) == null) {
                userRepository.saveUser(userId, jobString, 0);
            } else {
                userRepository.updateJob(userId, jobString);
            }

            return new SuccessResult(SUCCESS_RESULT_FORMAT, jobString);
        }

        return new ErrorResult("Did not match expected input. Please try again.");
    }
}
