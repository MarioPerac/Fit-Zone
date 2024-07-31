package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "program", schema = "fit_zone", catalog = "")
public class ProgramEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "descritpion")
    private String descritpion;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "level")
    private String level;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @OneToMany(mappedBy = "programId")
    private Collection<ImageEntity> imageEntities;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity categoryEntity;
    @OneToOne
    @JoinColumn(name = "program_image_id", referencedColumnName = "id", nullable = false)
    private ImageEntity programImageEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, descritpion, location,  price, level, duration);
    }

    public Collection<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(Collection<ImageEntity> imagesById) {
        this.imageEntities = imagesById;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryByCategoryId) {
        this.categoryEntity = categoryByCategoryId;
    }

    public ImageEntity getProgramImageEntity() {
        return programImageEntity;
    }

    public void setProgramImageEntity(ImageEntity imageByProgramImageId) {
        this.programImageEntity = imageByProgramImageId;
    }
}
