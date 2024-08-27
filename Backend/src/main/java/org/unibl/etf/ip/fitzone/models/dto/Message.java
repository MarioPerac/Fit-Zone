package org.unibl.etf.ip.fitzone.models.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Message {
    private Integer id;
    private String sender;
    private String receiver;
    private String content;
    private Timestamp created;
}
