package org.unibl.etf.ip.fitzone.models.entites;

import jakarta.persistence.*;
import org.unibl.etf.ip.fitzone.base.BaseEntity;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "user", schema = "fit_zone", catalog = "")
public class UserEntity implements BaseEntity<String> {
    @Id
    @jakarta.persistence.Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    @Column(name = "surname")
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mail")
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "avatar")
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "activated")
    private boolean activated = false;

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(password, that.password) && Objects.equals(mail, that.mail) && Objects.equals(avatar, that.avatar) && Objects.equals(activated, that.activated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, surname, password, mail, avatar, activated);
    }

    @Override
    public void setId(String object) {
        setUsername(object);
    }

    @Override
    public String getId() {
        return username;
    }
}
