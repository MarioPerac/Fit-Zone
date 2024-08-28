package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.dto.Chat;
import org.unibl.etf.ip.fitzone.models.dto.Message;
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

    public List<Chat> getAllFriendsName(String username){

        List<MessageEntity> messages = messageRepository.getAllBySenderOrReceiver(username, username);

        return messages.stream()
                .map(m -> m.getReceiver().equals(username) ? new Chat(m.getSender(), m.getSenderUser().getName() + " " + m.getSenderUser().getSurname())
                        : new Chat(m.getReceiver(), m.getReceiverUser().getName() + " " + m.getReceiverUser().getSurname() ))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Message> getAllMessagesWithFriend(String username, String friend)
    {
        List<MessageEntity> messageEntities = messageRepository.getAllMessagesWithFriend(username, friend);

        return messageEntities.stream().map(m -> modelMapper.map(m, Message.class)).collect(Collectors.toList());
    }
}
