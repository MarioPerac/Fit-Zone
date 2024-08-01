package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import org.unibl.etf.ip.fitzone.base.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "image", schema = "fit_zone", catalog = "")
public class ImageEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "data")
    private String data;
    @Basic
    @Column(name = "program_id")
    private Integer programId;
    @Basic
    @Column(name = "is_profile")
    private Boolean isProfile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public boolean getIsProfile() {
        return isProfile;
    }

    public void setIsProfile(boolean isProfile) {
        this.isProfile = isProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageEntity that = (ImageEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(programId, that.programId) && Objects.equals(isProfile, that.isProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, programId, isProfile);
    }
}
