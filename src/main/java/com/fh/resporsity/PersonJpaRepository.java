package com.fh.resporsity;

import com.fh.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonJpaRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
}
