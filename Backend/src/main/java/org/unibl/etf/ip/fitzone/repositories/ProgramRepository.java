package org.unibl.etf.ip.fitzone.repositories;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ip.fitzone.models.entites.ProgramEntity;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer> {
}
