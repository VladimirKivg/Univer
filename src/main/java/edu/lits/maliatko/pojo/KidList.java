package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "kid_list")
public class KidList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kid_id")
    private Kid kidId;

    @ManyToOne
    @JoinColumn(name = "kindergarten_id")
    private Kindergarten kindergartenId;

    @Column(name = "apply_date")
    private Date applyDate;

    public KidList() {
    }

    public KidList(Kid kidId, Kindergarten kindergartenId, Date applyDate) {
        this.kidId = kidId;
        this.kindergartenId = kindergartenId;
        this.applyDate = applyDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Kid getKidId() {
        return kidId;
    }

    public void setKidId(Kid kidId) {
        this.kidId = kidId;
    }

    public Kindergarten getKindergartenId() {
        return kindergartenId;
    }

    public void setKindergartenId(Kindergarten kindergartenId) {
        this.kindergartenId = kindergartenId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Override
    public String toString() {
        return "KidList{" +
                "id=" + id +
                ", kidId=" + kidId +
                ", kindergartenId=" + kindergartenId +
                ", applyDate=" + applyDate +
                '}';
    }
}
