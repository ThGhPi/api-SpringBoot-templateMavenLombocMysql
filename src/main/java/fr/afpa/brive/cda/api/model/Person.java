package fr.afpa.brive.cda.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok annotation to automatically generate getters, setters, equals, hashCode, toString, etc.
@Entity // specifies that this class is an entity to hibernate ? and is mapped to a database table.
@Table(name= "person") // Specifies the table name in the database.
public class Person {

    @Id // id column for the table and id of the instance
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-generates ID values with help of a person_seq table // might be conflict when adding data via db administrator
    @Column(name= "idperson")
    private int id;

    //@Column(name= "lastname") // uncomment if custom column name needed
    private String lastname; // also default name for the column

    //@Column(name= "firstname" // uncomment if custom column name needed
    private String firstname; // also default name for the column
}
