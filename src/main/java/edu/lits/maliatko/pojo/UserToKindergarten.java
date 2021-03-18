package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "user_to_kindergarten")
public class UserToKindergarten {//user_to_kindergarten
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;//id

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne()
    @JoinColumn(name = "kindergarten_id")
    private Kindergarten kindergartenId;

    public UserToKindergarten() {
    }

    public UserToKindergarten(User userId, Kindergarten kindergartenId) {
        this.userId = userId;
        this.kindergartenId = kindergartenId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Kindergarten getKindergartenId() {
        return kindergartenId;
    }

    public void setKindergartenId(Kindergarten kindergartenId) {
        this.kindergartenId = kindergartenId;
    }

    @Override
    public String toString() {
        return "UserToKindergarten{" +
                "id=" + id +
                ", userId=" + userId +
                ", kindergartenId=" + kindergartenId +
                '}';
    }
}
