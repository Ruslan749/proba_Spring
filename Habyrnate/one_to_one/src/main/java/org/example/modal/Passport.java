package org.example.modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private int passportNumber;

    @OneToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person person;

    public Passport() {
    }

    public Passport( int passportNumber) {
        this.person = person;
        this.passportNumber = passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "passport{" +
                "person=" + person +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
