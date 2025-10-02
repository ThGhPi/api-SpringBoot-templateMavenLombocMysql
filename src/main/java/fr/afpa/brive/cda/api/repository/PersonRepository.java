package fr.afpa.brive.cda.api.repository;

import fr.afpa.brive.cda.api.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // indicates that this interface is a Spring Data repository.
public interface PersonRepository extends CrudRepository<Person, Integer> {
    // provides basic CRUD operations on the Person entity.
    // no need to define methods; they are inherited from CrudRepository.
}