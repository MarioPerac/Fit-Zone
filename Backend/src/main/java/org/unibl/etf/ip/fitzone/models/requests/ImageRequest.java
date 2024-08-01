package org.unibl.etf.ip.fitzone.models.requests;

import lombok.Data;

import javax.swing.text.StyledEditorKit;

@Data
public class ImageRequest {
    private String data;
    private Integer programId;
    private Boolean isProfile;
}
