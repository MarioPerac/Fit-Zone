package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.models.dto.Image;
import org.unibl.etf.ip.fitzone.models.requests.ImageRequest;
import org.unibl.etf.ip.fitzone.services.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController extends CrudController<Integer, ImageRequest, Image> {

    public ImageController(ImageService imageService){
        super(imageService, Image.class);
    }
}
