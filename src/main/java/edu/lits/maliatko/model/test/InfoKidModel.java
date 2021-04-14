package edu.lits.maliatko.model.test;

import edu.lits.maliatko.pojo.Address;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.service.InfoKidService;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;


public class InfoKidModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
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

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne()
    @JoinColumn(name = "parent_one_id")
    private User userParentOne;

    @Column(name = "benefits")
    private String benefits;

    @Column(name = "status")
    private String status;

    @ManyToOne()
    @JoinColumn(name = "parent_two_id",nullable = true)
    private User userParentTwo;

    @Column(name = "medical_data_id")
    private Integer medicalDataId;

    @Column(name = "register_to_garden_date")
    private Date registerToGardenDate;

    @ManyToOne()
    @JoinColumn(name = "cluster_id",nullable = true)
    private Cluster cluster;


}
