package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "user_to_group")
public class UserToGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;    // id

//    @ManyToOne
    private User userId;   // user_id
//    @ManyToOne
    private GroupA groupId;   // group_id

}
