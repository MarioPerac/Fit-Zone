package org.unibl.etf.ip.fitzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ip.fitzone.models.entites.MessageEntity;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

    public List<MessageEntity> getAllBySenderOrReceiver(String sender, String receiver);
}
