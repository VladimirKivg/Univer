package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.dao.DataAccessResourceFailureException;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
@Entity(name = "user")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
   @GenericGenerator(name = "native",strategy ="native" )
   private Integer id;
   @Column(name = "surname")
   private String surname;
   @Column(name = "name")
   private String name;
   @Column(name = "father_name")
   private String fatherName;//father_name
   @Column(name = "birth_date")
   private Date birthDate;
   @Column(name = "phone")
   private String phone;
   @Column(name = "mail")
   private String mail;
   @Column(name = "passport_id")
   private Integer passportId;

   /*  @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "address_id") */
   private Address addressId;

   @Column(name = "login")
   private String login;
   @Column(name = "password")
   private String password;
}
