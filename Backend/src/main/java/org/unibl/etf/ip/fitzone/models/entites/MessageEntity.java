package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.fitzone.base.BaseEntity;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "message", schema = "fit_zone")
public class MessageEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "sender")
    private String sender;
    @Basic
    @Column(name = "receiver")
    private String receiver;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "created")
    private Timestamp created = new Timestamp(System.currentTimeMillis());

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender", insertable = false, updatable = false)
    private UserEntity senderUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver", insertable = false, updatable = false)
    private UserEntity receiverUser;
}
