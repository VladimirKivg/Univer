package edu.lits.maliatko.pojo;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.dao.DataAccessResourceFailureException;

import javax.xml.crypto.Data;
import java.util.Date;

public class User {
   private Integer id;
   private String surname;
   private String name;
   private String fatherName;//father_name
   private Date birthDate;
   private String phone;
   private String mail;
   private Integer passportId;
   private Integer addressId;
   private String login;
   private String password;
}
