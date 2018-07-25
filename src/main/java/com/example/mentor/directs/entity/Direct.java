package com.example.mentor.directs.entity;

        import javax.persistence.*;

@Entity
@Table(name = "DIRECTS")
public class Direct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
}
