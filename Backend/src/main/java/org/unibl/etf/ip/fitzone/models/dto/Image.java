package org.unibl.etf.ip.fitzone.models.dto;

import lombok.Data;

@Data
public class Image {

    private Integer id;
    private String data;
    private Integer programId;
    private Boolean isProfile;
}
