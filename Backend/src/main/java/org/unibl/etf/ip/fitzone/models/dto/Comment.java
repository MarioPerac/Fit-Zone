package org.unibl.etf.ip.fitzone.models.dto;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    private Integer id;
    private String question;
    private String answer;
    private String userUsername;
    private Integer programId;
    private Timestamp date;
}
