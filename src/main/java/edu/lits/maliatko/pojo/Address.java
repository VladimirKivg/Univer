package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy ="native" )
    private Integer id; //`id`
    @Column(name = "region")
    private String region; //`region
    @Column(name = "city")
    private String city; //`city`
    @Column(name = "street")
    private String street; //`street`
    @Column(name = "building_number")
    private Integer buildingNumber; //`building_number`
    @Column(name = "apartment")
    private Integer apartment; //`apartment`
}
