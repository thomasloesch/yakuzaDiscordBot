package org.github.thomasloesch.yakuzaBot.model;

public class User {
    private String jobName;
    private long discordID;
    private int balance;

    public User(String jobName, long discordID, int balance) {
        setJobName(jobName);
        setDiscordID(discordID);
        setBalance(balance);
    }

    public User(String jobName, long discordID) {
        setJobName(jobName);
        setDiscordID(discordID);
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public long getDiscordID() {
        return discordID;
    }

    public void setDiscordID(long discordID) {
        this.discordID = discordID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
