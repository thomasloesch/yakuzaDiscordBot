package org.github.thomasloesch.yakuzaBot.model;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;
import java.util.ArrayList;

public class WorkCommandHandler extends DiscordCommandHandler {
    private final String MESSAGE_MATCH_REGEX = ".*";
    private final String SUCCESS_RESULT_STRING = "You have been assigned as a: ";

    private ArrayList<String> possibleJobArr;
    private IUserRepository userRepository;
    private static String REPO_FILE_LOCATION = "C:\\Users\\Thomas Loesch\\IdeaProjects\\yakuzaBot\\repoFile.csv";

    public WorkCommandHandler() {
        InitializeJobArr();
        userRepository = new FileUserRepository(new File(REPO_FILE_LOCATION));
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

            return new SuccessResult(jobString, SUCCESS_RESULT_STRING);
        }

        return new ErrorResult("Did not match expected input. Please try again.");
    }
}
