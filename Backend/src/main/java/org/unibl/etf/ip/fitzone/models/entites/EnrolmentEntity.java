package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import org.unibl.etf.ip.fitzone.base.BaseEntity;

import java.sql.Date;
import java.util.Objects;

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
    @Basic
    @Column(name = "date")
    private Date date = new Date(System.currentTimeMillis());

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userUsername) {
        this.username = userUsername;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentEntity that = (EnrolmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(programId, that.programId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, programId, date);
    }
}
