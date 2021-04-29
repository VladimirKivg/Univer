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

    @ManyToOne
    @JoinColumn(name = "kid_id")
    private Child child;

    @Column(name = "visiting_date")
    private Date visitingDate;

    @Column(name = "presence")
    private Integer presence;

    @ManyToOne
    @JoinColumn(name = "user_logger_id")
    private User userLogger;

    public Visiting() {
    }

    public Visiting(Child child, Date visitingDate, Integer presence, User userLogger) {
        this.child = child;
        this.visitingDate = visitingDate;
        this.presence = presence;
        this.userLogger = userLogger;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
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

    public User getUserLogger() {
        return userLogger;
    }

    public void setUserLogger(User userLogger) {
        this.userLogger = userLogger;
    }

    @Override
    public String toString() {
        return "Visiting{" +
                "id=" + id +
                ", kidId=" + child +
                ", visitingDate=" + visitingDate +
                ", presence=" + presence +
                ", userLoggerId=" + userLogger +
                '}';
    }
}
