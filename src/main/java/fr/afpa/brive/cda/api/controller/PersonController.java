package fr.afpa.brive.cda.api.controller;

import fr.afpa.brive.cda.api.model.Person;
import fr.afpa.brive.cda.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // marks the class as a REST controller where each method returns a domain object instead of a view.
public class PersonController {

    @Autowired // injects the PersonService to handle business logic.
    private PersonService personService;

    @PostMapping("/person") // handles HTTP POST request to create a new person.
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/persons") // handles HTTP GET request to retrieve all persons.
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/person/{id}") // handles HTTP GET request to retrieve a person by their ID.
    public Person getPerson(@PathVariable("id") int id) {
        Optional<Person> person = personService.getPerson(id);
        return person.orElse(null);
    }

    @PutMapping("/person/{id}") // handles HTTP PUT request to update an existing person's data.
    public Person updateEmployee(@PathVariable("id") int id, @RequestBody Person person) {
        Optional<Person> e = personService.getPerson(id);
        if(e.isPresent()) { // if person found
            Person current = e.get();

            String firstName = person.getFirstname();
            if(firstName != null) { // update firstname if provide
                current.setFirstname(firstName);
            }
            String lastName = person.getLastname();
            if(lastName != null) { // update lastname if provided
                current.setLastname(lastName);
            }
            personService.savePerson(current); // save updated person
            return  current;
        } else { return null; } // if person not found
    }

    @DeleteMapping("/person/{id}") // handles HTTP DELETE request to remove a person by ID.
    public void deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }
}
