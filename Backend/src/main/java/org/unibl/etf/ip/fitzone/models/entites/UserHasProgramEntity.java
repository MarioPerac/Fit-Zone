package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import org.unibl.etf.ip.fitzone.models.keys.UserHasProgramKeys;

import java.util.Objects;

@Entity
@Table(name = "user_has_program", schema = "fit_zone", catalog = "")
@IdClass(UserHasProgramKeys.class)
public class UserHasProgramEntity {
    @Id
    @jakarta.persistence.Column(name = "user_username")
    private String userUsername;

    public UserHasProgramEntity(){}

    public UserHasProgramEntity(String username, Integer id) {
        this.userUsername = username;
        this.programId = id;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @Id
    @jakarta.persistence.Column(name = "program_id")
    private Integer programId;

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHasProgramEntity that = (UserHasProgramEntity) o;
        return Objects.equals(userUsername, that.userUsername) && Objects.equals(programId, that.programId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userUsername, programId);
    }
}
