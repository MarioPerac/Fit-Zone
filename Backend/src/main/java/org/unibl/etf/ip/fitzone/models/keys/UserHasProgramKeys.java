package org.unibl.etf.ip.fitzone.models.keys;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserHasProgramKeys implements Serializable {

    private String userUsername;
    private Integer programId;
}
