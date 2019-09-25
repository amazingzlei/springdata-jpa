package com.fh.resporsity;

import com.fh.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Integer> {
}
