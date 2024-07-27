package org.unibl.etf.ip.fitzone.models.dto;

import lombok.Data;

@Data
public class User {

    private String username;
    private String name;
    private String surname;
    private String mail;
    private String avatar;
    private Boolean activated;
}
