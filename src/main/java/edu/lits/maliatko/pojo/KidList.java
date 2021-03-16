package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "kid_list")
public class KidList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
private Integer id;    // id

//    @ManyToOne
private Kid kidId;   // kid_id
    //    @ManyToOne
private Kindergarten kindergartenId;   // kindergarten_id

    @Column(name = "apply_date")
    private Date applyDate;  // apply_date

}
