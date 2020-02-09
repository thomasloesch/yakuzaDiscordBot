package org.github.thomasloesch.yakuzaBot.model;

public class SuccessResult extends HandlerResult {
    private String format;
    private String message;

    public SuccessResult(String format, String message) {
        super();
        this.format = format;
        this.message = message;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getResultString() {
        return String.format(format, message);
    }
}
