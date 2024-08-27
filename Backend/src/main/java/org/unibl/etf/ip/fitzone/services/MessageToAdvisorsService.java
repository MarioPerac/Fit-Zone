package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.base.CrudService;
import org.unibl.etf.ip.fitzone.models.entites.MessageToAdvisorsEntity;
import org.unibl.etf.ip.fitzone.repositories.MessageToAdvisisorsRepository;

@Service
public class MessageToAdvisorsService extends CrudJpaService<MessageToAdvisorsEntity, Integer> {
    public MessageToAdvisorsService(MessageToAdvisisorsRepository jpaRepository, ModelMapper modelMapper) {
        super(jpaRepository, MessageToAdvisorsEntity.class, modelMapper);
    }
}
