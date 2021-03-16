package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "visiting")
public class Visiting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id; // `id`

//    @ManyToOne()
    private Kid kidId; // `kid_id`

    @Column(name = "visiting_date")
    private Date visitingDate; // `visiting_date`
    @Column(name = "presence")
    private Integer presence; // `presence`

//    @ManyToOne()
    private User userLoggerId; // `user_logger_id`
}
