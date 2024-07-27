package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "image", schema = "fit_zone", catalog = "")
public class ImageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "path")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "program_id")
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
        ImageEntity that = (ImageEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(path, that.path) && Objects.equals(programId, that.programId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, programId);
    }
}
