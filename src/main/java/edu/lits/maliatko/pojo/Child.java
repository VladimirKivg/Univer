package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "child")
public class Child {

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
    private User userParentOne;//

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
    @JoinColumn(name = "cluster_id")
    private Cluster cluster;

    public Child() {
    }

    public Child(String surname, String name, String fatherName, Date birthDate, String gender, String birthDocument, Address address, User userParentOne, String benefits, String status, User userParentTwo, Integer medicalDataId, Date registerToGardenDate, Cluster cluster) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.birthDocument = birthDocument;
        this.address = address;
        this.userParentOne = userParentOne;
        this.benefits = benefits;
        this.status = status;
        this.userParentTwo = userParentTwo;
        this.medicalDataId = medicalDataId;
        this.registerToGardenDate = registerToGardenDate;
        this.cluster = cluster;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDocument() {
        return birthDocument;
    }

    public void setBirthDocument(String birthDocument) {
        this.birthDocument = birthDocument;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUserParentOne() {
        return userParentOne;
    }

    public void setUserParentOne(User userParentOne) {
        this.userParentOne = userParentOne;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserParentTwo() {
        return userParentTwo;
    }

    public void setUserParentTwo(User userParentTwo) {
        this.userParentTwo = userParentTwo;
    }

    public Integer getMedicalDataId() {
        return medicalDataId;
    }

    public void setMedicalDataId(Integer medicalDataId) {
        this.medicalDataId = medicalDataId;
    }

    public Date getRegisterToGardenDate() {
        return registerToGardenDate;
    }

    public void setRegisterToGardenDate(Date registerToGardenDate) {
        this.registerToGardenDate = registerToGardenDate;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster classId) {
        this.cluster = classId;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", birthDocument='" + birthDocument + '\'' +
                ", addressId=" + address +
                ", parentOneId=" + userParentOne +
                ", benefits='" + benefits + '\'' +
                ", status='" + status + '\'' +
                ", parentTwoId=" + userParentTwo +
                ", medicalDataId=" + medicalDataId +
                ", registerToGardenDate=" + registerToGardenDate +
                ", group=" + cluster +
                '}';
    }
}
