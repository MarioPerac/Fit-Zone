package org.unibl.etf.ip.fitzone.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class Program {
    private Integer id;
    private String name;
    private String description;
    private String location;
    private Integer categoryId;
    private Category category;
    private Integer price;
    private String level;
    private Integer duration;
    private Boolean isActive;
    private List<Image> images;
    private List<Comment> comments;
}
