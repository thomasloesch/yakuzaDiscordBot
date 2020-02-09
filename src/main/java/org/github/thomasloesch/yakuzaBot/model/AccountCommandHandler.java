package org.github.thomasloesch.yakuzaBot.model;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.event.message.MessageCreateEvent;

public class AccountCommandHandler extends DiscordCommandHandler {
    private final String SUCCESS_RESULT_FOUND = "Found user: %s";
    private final String SUCCESS_RESULT_NOT_FOUND = "User %s not found!";

    private IUserRepository userRepository;

    public AccountCommandHandler() {
        userRepository = RepositoryFactory.getRepositoryInstance();
    }

    @Override
    public HandlerResult handle(MessageCreateEvent commandContext) {
        MessageAuthor author = commandContext.getMessage().getAuthor();

        User user = userRepository.getUser(author.getId());
        if (user == null) {
            return new SuccessResult(SUCCESS_RESULT_NOT_FOUND, author.getIdAsString());
        } else {
            return new SuccessResult(SUCCESS_RESULT_FOUND, user.toString());
        }
    }
}
