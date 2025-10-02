package fr.afpa.brive.cda.api.service;

import fr.afpa.brive.cda.api.model.Person;
import fr.afpa.brive.cda.api.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data // Lombok annotation for generating boilerplate code (getters, setters, etc.)
@Service // marks this class as a Spring service component.
public class PersonService {

    @Autowired // inject PersonRepository interface to retrieve the query methods and handle new query methods (such findTop3ByAge(int age))
    private PersonRepository personRepository;

    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    } // retrieves a person by ID

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    } // retrieves all person from db

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    } // deletes a person based on ID

    public Person savePerson(Person person) {
        return personRepository.save(person);
    } //saves (creates) or updates a person entity in db table person
}
