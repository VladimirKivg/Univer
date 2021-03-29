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
    private User user;

    @ManyToOne()
    @JoinColumn(name = "kindergarten_id")
    private Kindergarten kindergarten;

    public UserToKindergarten() {
    }

    public UserToKindergarten(User user, Kindergarten kindergarten) {
        this.user = user;
        this.kindergarten = kindergarten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Kindergarten getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }

    @Override
    public String toString() {
        return "UserToKindergarten{" +
                "id=" + id +
                ", userId=" + user +
                ", kindergartenId=" + kindergarten +
                '}';
    }
}
