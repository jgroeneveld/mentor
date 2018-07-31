package de.jgroeneveld.mentor.directs.entity;

import de.jgroeneveld.mentor.managers.entity.Manager;

import javax.persistence.*;

@Entity
@Table(name = "DIRECTS")
public class Direct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @OneToOne
    private Manager manager;

    public Direct() {
    }

    public Direct(String firstName, String lastName, Manager manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Manager getManager() {
        return manager;
    }
}
