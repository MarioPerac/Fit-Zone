package org.unibl.etf.ip.fitzone.models.requests;

import lombok.Data;

@Data
public class MessageRequest {
    private String sender;
    private String receiver;
    private String content;
}
