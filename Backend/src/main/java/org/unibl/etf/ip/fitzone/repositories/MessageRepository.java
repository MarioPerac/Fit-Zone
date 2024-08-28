package org.unibl.etf.ip.fitzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ip.fitzone.models.entites.MessageEntity;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

    public List<MessageEntity> getAllBySenderOrReceiver(String sender, String receiver);


    @Query("SELECT m FROM MessageEntity m WHERE " +
            "(m.sender = :username AND m.receiver = :friend) OR " +
            "(m.sender = :friend AND m.receiver = :username)")
    List<MessageEntity> getAllMessagesWithFriend(@Param("username") String username, @Param("friend") String friend);

}
