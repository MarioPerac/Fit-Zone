package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.entites.EnrolmentEntity;
import org.unibl.etf.ip.fitzone.repositories.EnrolmentRepository;

@Service
public class EnrolmentService extends CrudJpaService<EnrolmentEntity, Integer> {

    public EnrolmentService(EnrolmentRepository jpaRepository, ModelMapper modelMapper) {
        super(jpaRepository, EnrolmentEntity.class, modelMapper);
    }
}
