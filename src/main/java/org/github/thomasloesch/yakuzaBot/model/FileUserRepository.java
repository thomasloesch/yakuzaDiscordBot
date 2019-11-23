package org.github.thomasloesch.yakuzaBot.model;

import java.io.File;

public class FileUserRepository implements IUserRepository {
    private File repoFile;

    public FileUserRepository(File repoFile) {
        this.repoFile = repoFile;
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public boolean saveUser(long id, String jobName, int balance) {
        return false;
    }

    @Override
    public boolean updateJob(long id, String jobName) {
        return false;
    }

    @Override
    public boolean updateBalance(long id, int balance) {
        return false;
    }

}
