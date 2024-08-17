package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.fitzone.base.BaseEntity;

import java.sql.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "enrolment", schema = "fit_zone")
public class EnrolmentEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_username")
    private String username;
    @Basic
    @Column(name = "program_id")
    private Integer programId;
    @ManyToOne
    @JoinColumn(name = "program_id", insertable = false, updatable = false)
    private ProgramEntity programEntity;
    @Basic
    @Column(name = "date")
    private Date date = new Date(System.currentTimeMillis());


}
