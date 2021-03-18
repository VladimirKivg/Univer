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
    private GroupA groupId;

    public UserToGroup() {
    }

    public UserToGroup(User userId, GroupA groupId) {
        this.userId = userId;
        this.groupId = groupId;
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

    public GroupA getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupA groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "UserToGroup{" +
                "id=" + id +
                ", userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }
}
