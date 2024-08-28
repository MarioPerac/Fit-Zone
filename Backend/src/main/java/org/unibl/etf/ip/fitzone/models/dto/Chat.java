package org.unibl.etf.ip.fitzone.models.dto;

import lombok.Data;

@Data
public class Chat {

    private String friendName;
    private String friendUsername;

    public Chat(String username, String name){
        this.friendUsername =username;
        this.friendName = name;
    }
}
