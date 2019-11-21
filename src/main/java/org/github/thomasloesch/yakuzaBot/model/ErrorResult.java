package org.github.thomasloesch.yakuzaBot.model;

public class ErrorResult extends HandlerResult {
    private String message;

    public ErrorResult(String message) {
        super();

        this.message = message;
    }

    @Override
    public String getResultString() {
        return message;
    }
}
