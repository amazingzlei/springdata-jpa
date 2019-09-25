package com.fh.resporsity;

import com.fh.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonPagingAndSortingRepository extends PagingAndSortingRepository<Person, Integer> {
}
