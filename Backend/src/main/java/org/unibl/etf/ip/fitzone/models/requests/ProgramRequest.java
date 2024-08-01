package org.unibl.etf.ip.fitzone.models.requests;


import lombok.Data;
import org.unibl.etf.ip.fitzone.models.dto.Category;
import org.unibl.etf.ip.fitzone.models.dto.Image;

@Data
public class ProgramRequest {
    private String name;
    private String description;
    private String location;
    private Integer categoryId;
    private Integer price;
    private String level;
    private Integer duration;
}
