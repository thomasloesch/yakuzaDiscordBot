package org.github.thomasloesch.yakuzaBot.model;

public class SuccessResult extends HandlerResult {
    private String jobString;
    private String message;

    public SuccessResult(String jobString, String message) {
        super();
        this.jobString = jobString;
        this.message = message;
    }

    public String getJobString() {
        return jobString;
    }

    public void setJobString(String jobString) {
        this.jobString = jobString;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getResultString() {
        return this.message + jobString;
    }
}
