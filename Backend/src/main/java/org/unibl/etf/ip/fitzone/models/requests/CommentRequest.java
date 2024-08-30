package org.unibl.etf.ip.fitzone.models.requests;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentRequest {
    private String question;
    private String answer;
    private String userUsername;
    private Integer programId;
}
