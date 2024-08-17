package org.unibl.etf.ip.fitzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ip.fitzone.models.entites.EnrolmentEntity;
import org.unibl.etf.ip.fitzone.models.entites.ProgramEntity;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<EnrolmentEntity, Integer> {

    public List<EnrolmentEntity> getAllByUsernameAndProgramEntity_IsActive(String username, Boolean status);
}
