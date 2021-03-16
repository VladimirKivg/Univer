package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity(name = "user_to_role")
public class userToRole {//user_to_role
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;//id

    /*  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") */
    private User userId;//user_id

    /*  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id") */
    private Role roleId;//role_id
}
