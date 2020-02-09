package org.github.thomasloesch.yakuzaBot.model;

import java.io.File;

public class RepositoryFactory {
    private static String REPO_FILE_LOCATION = "C:\\Users\\Thomas Loesch\\IdeaProjects\\yakuzaBot\\repoFile.csv";

    public static IUserRepository getRepositoryInstance() {
        return new FileUserRepository(new File(REPO_FILE_LOCATION));
    }
}
