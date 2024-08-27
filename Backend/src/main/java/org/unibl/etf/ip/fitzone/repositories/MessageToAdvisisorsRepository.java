package org.unibl.etf.ip.fitzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ip.fitzone.models.entites.MessageToAdvisorsEntity;

@Repository
public interface MessageToAdvisisorsRepository extends JpaRepository<MessageToAdvisorsEntity, Integer> {
}
