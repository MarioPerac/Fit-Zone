package org.unibl.etf.ip.fitzone.models.dto;

import lombok.Data;

@Data
public class Program {
    private Integer id;
    private String name;
    private String description;
    private String location;
    private Integer categoryId;
    private Integer price;
    private String level;
    private Integer duration;
}
