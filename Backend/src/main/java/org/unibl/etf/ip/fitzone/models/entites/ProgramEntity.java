package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "program", schema = "fit_zone", catalog = "")
public class ProgramEntity {
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
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "descritpion")
    private String descritpion;

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    @Basic
    @Column(name = "location")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "category_id")
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "price")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "level")
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "duration")
    private Integer duration;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "program_image_id")
    private Integer programImageId;

    public Integer getProgramImageId() {
        return programImageId;
    }

    public void setProgramImageId(Integer programImageId) {
        this.programImageId = programImageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramEntity that = (ProgramEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(descritpion, that.descritpion) && Objects.equals(location, that.location) && Objects.equals(categoryId, that.categoryId) && Objects.equals(price, that.price) && Objects.equals(level, that.level) && Objects.equals(duration, that.duration) && Objects.equals(programImageId, that.programImageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descritpion, location, categoryId, price, level, duration, programImageId);
    }
}
