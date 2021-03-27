package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "visiting")
public class Visiting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "kid_id")
    private Child kidId;

    @Column(name = "visiting_date")
    private Date visitingDate;

    @Column(name = "presence")
    private Integer presence;

    @ManyToOne()
    @JoinColumn(name = "user_logger_id")
    private User userLoggerId;

    public Visiting() {
    }

    public Visiting(Child kidId, Date visitingDate, Integer presence, User userLoggerId) {
        this.kidId = kidId;
        this.visitingDate = visitingDate;
        this.presence = presence;
        this.userLoggerId = userLoggerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Child getKidId() {
        return kidId;
    }

    public void setKidId(Child kidId) {
        this.kidId = kidId;
    }

    public Date getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(Date visitingDate) {
        this.visitingDate = visitingDate;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public User getUserLoggerId() {
        return userLoggerId;
    }

    public void setUserLoggerId(User userLoggerId) {
        this.userLoggerId = userLoggerId;
    }

    @Override
    public String toString() {
        return "Visiting{" +
                "id=" + id +
                ", kidId=" + kidId +
                ", visitingDate=" + visitingDate +
                ", presence=" + presence +
                ", userLoggerId=" + userLoggerId +
                '}';
    }
}
