package org.unibl.etf.ip.fitzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ip.fitzone.models.entites.UserHasProgramEntity;
import org.unibl.etf.ip.fitzone.models.keys.UserHasProgramKeys;

import java.util.List;

@Repository
public interface UserHasProgramRepository extends JpaRepository<UserHasProgramEntity, UserHasProgramKeys> {

    public List<UserHasProgramEntity> getUserHasProgramEntitiesByUserUsername(String username);
}
