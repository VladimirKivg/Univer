package edu.lits.maliatko.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "kindergarten")
public class Kindergarten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;        // id

    @Column(name = "number")
    private Integer number;  // number

    @Column(name = "name")
    private String name;     // name

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address addressId;

    public Kindergarten() {
    }

    public Kindergarten(Integer number, String name, Address addressId) {
        this.number = number;
        this.name = name;
        this.addressId = addressId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Kindergarten{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
