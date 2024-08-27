package org.unibl.etf.ip.fitzone.models.requests;

import lombok.Data;

@Data
public class MessageToAdvisorsRequest {

    private String title;
    private String content;
    private String username;

    public MessageToAdvisorsRequest(String title, String content, String userUsername) {
        this.title = title;
        this.content = content;
        this.username = userUsername;
    }
}
