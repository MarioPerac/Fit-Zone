package org.unibl.etf.ip.fitzone.models.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MessageToAdvisors {
    private Integer id;
    private String title;
    private String content;
    private String userUsername;
    private Boolean isRead;
}
