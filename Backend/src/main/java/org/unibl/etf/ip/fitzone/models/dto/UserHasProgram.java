package org.unibl.etf.ip.fitzone.models.dto;

import lombok.Data;

@Data
public class UserHasProgram {
    private Program program;
    private String username;
    private String fullName;

    public UserHasProgram(Program program, String username, String fullName) {
        this.program = program;
        this.username = username;
        this.fullName = fullName;
    }
}
