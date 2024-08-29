package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.fitzone.models.keys.UserHasProgramKeys;

import java.util.Objects;

@Data
@Entity
@Table(name = "user_has_program", schema = "fit_zone")
@IdClass(UserHasProgramKeys.class)
public class UserHasProgramEntity {
    @Id
    @jakarta.persistence.Column(name = "user_username")
    private String userUsername;

    @Id
    @jakarta.persistence.Column(name = "program_id")
    private Integer programId;

    @ManyToOne
    @JoinColumn(name = "program_id", insertable = false, updatable = false)
    private ProgramEntity programEntity;

    @ManyToOne
    @JoinColumn(name = "user_username", insertable = false, updatable = false)
    private UserEntity userEntity;

    public UserHasProgramEntity(){}

    public UserHasProgramEntity(String username, Integer id) {
        this.userUsername = username;
        this.programId = id;
    }
}
