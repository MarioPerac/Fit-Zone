package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.entites.ImageEntity;
import org.unibl.etf.ip.fitzone.repositories.ImageRepository;

@Service
public class ImageService extends CrudJpaService<ImageEntity, Integer> {

    public ImageService(ImageRepository imageRepository, ModelMapper modelMapper){
        super(imageRepository, ImageEntity.class, modelMapper);
    }
}
