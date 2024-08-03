package org.unibl.etf.ip.fitzone.models.dto;
import java.io.Serializable;

public class Mail implements Serializable {

    private String to;
    private String toFullName;
    private String toUsername;

    public Mail() {

    }

    public Mail(String to, String toFullName, String toUsername) {
        this.to = to;
        this.toFullName = toFullName;
        this.toUsername = toUsername;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToFullName() {
        return toFullName;
    }

    public void setToFullName(String toFullName) {
        this.toFullName = toFullName;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }
}
