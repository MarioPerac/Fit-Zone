package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.dto.Chat;
import org.unibl.etf.ip.fitzone.models.entites.MessageEntity;
import org.unibl.etf.ip.fitzone.repositories.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService extends CrudJpaService<MessageEntity, Integer> {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository jpaRepository, ModelMapper modelMapper) {
        super(jpaRepository, MessageEntity.class, modelMapper);
        this.messageRepository = jpaRepository;
    }

    public List<String> getAllFriendsName(String username){

        List<MessageEntity> messages = messageRepository.getAllBySenderOrReceiver(username, username);

        return messages.stream().map(m -> m.getReceiver().equals(username) ? m.getSender() : m.getReceiver()).distinct().collect(Collectors.toList());
    }
}
