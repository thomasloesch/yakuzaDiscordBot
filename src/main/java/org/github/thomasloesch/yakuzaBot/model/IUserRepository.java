package org.github.thomasloesch.yakuzaBot.model;

public interface IUserRepository {
    public User getUser(long id);
    public boolean saveUser(long id, String jobName, int balance);
    public boolean updateJob(long id, String jobName);
    public boolean updateBalance(long id, int balance);
}
