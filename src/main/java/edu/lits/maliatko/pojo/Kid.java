package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "kid")
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id;
     @Column(name = "surname")
    private String surname;
    @Column(name = "name")
     private String name;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birth_document")
    private String birthDocument;

//    @ManyToOne()
    private Address addressId;
    //    @ManyToOne()
    private User parentOneId;

    @Column(name = "benefits")
    private String benefits;
    @Column(name = "status")
    private String status;

    //    @ManyToOne()
    private User parentTwoId;

    @Column(name = "medical_data_id")
    private Integer medicalDataId;
    @Column(name = "register_to_garden_date")
    private Date registerToGardenDate;

    //    @ManyToOne()
    private GroupA groupId;


}
