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
    private User userId;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Cluster classId;

    public UserToGroup() {
    }

    public UserToGroup(User userId, Cluster classId) {
        this.userId = userId;
        this.classId = classId;
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

    public Cluster getGroupId() {
        return classId;
    }

    public void setGroupId(Cluster classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "UserToGroup{" +
                "id=" + id +
                ", userId=" + userId +
                ", groupId=" + classId +
                '}';
    }
}
