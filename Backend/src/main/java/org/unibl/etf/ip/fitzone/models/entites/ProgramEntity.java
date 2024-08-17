package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.fitzone.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "program", schema = "fit_zone", catalog = "")
public class ProgramEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "category_id")
    private Integer categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity categoryEntity;

    @Basic
    @Column(name = "price")
    private Integer price;

    @Basic
    @Column(name = "is_active")
    private Boolean isActive = true;
    @Basic
    @Column(name = "level")
    private String level;
    @Basic
    @Column(name = "duration")
    private Integer duration;

    @OneToMany(mappedBy = "programId", fetch = FetchType.LAZY)
    private List<ImageEntity> images;
}
