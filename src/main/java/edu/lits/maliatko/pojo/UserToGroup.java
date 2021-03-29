package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "user_to_group")
public class UserToGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;    // id

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Cluster cluster;

    public UserToGroup() {
    }

    public UserToGroup(User user, Cluster cluster) {
        this.user = user;
        this.cluster = cluster;
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

    public Cluster getGroupId() {
        return cluster;
    }

    public void setGroupId(Cluster classId) {
        this.cluster = classId;
    }

    @Override
    public String toString() {
        return "UserToGroup{" +
                "id=" + id +
                ", userId=" + user +
                ", groupId=" + cluster +
                '}';
    }
}
