package com.fh.service;

import com.fh.entity.Person;
import com.fh.resporsity.PersonCrudRepository;
import com.fh.resporsity.PersonJpaRepository;
import com.fh.resporsity.PersonPagingAndSortingRepository;
import com.fh.resporsity.PersonRepsotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepsotory personRepsotory;
    @Autowired
    private PersonCrudRepository personCrudRepository;
    @Autowired
    private PersonPagingAndSortingRepository pagingAndSortingRepository;
    @Autowired
    private PersonJpaRepository jpaRepository;

    @Transactional
    public int update(int id, int age){
        return personRepsotory.updatePerson(id, age);
    }

    public int saveList(List<Person> personList){
        try{
            personCrudRepository.save(personList);
            return 1;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public long count(){
        return personCrudRepository.count();
    }

    public Person find(Integer id){
        return personCrudRepository.findOne(id);
    }

    public Page findSortAndPage(){

        int current = 3;
        int limit = 5;
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"id");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC,"birth");
        Sort sort = new Sort(order1,order2);
        Pageable pageable = new PageRequest(current,limit,sort);
        return pagingAndSortingRepository.findAll(pageable);
    }

    public Person saveAndFlush(){
        Person person = new Person();
        person.setName("ZA");
        person.setAddressId(2);
        person.setAge(26);
        person.setBirth(new Date());
        return jpaRepository.saveAndFlush(person);
    }

    public void specification(){
        int pageNo = 3 - 1;
        int pageSize = 5;
        PageRequest pageable = new PageRequest(pageNo, pageSize);

        //通常使用 Specification 的匿名内部类
        Specification<Person> specification = new Specification<Person>() {
            /**
             * @param *root: 代表查询的实体类.
             * @param query: 可以从中可到 Root 对象, 即告知 JPA Criteria 查询要查询哪一个实体类. 还可以
             * 来添加查询条件, 还可以结合 EntityManager 对象得到最终查询的 TypedQuery 对象.
             * @param *cb: CriteriaBuilder 对象. 用于创建 Criteria 相关对象的工厂. 当然可以从中获取到 Predicate 对象
             * @return: *Predicate 类型, 代表一个查询条件.
             */
            public Predicate toPredicate(Root<Person> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path path = root.get("id");
                Predicate predicate = cb.gt(path, 5);
                return predicate;
            }
        };

        Page<Person> page = jpaRepository.findAll(specification, pageable);

        System.out.println("总记录数: " + page.getTotalElements());
        System.out.println("当前第几页: " + (page.getNumber() + 1));
        System.out.println("总页数: " + page.getTotalPages());
        System.out.println("当前页面的 List: " + page.getContent());
        System.out.println("当前页面的记录数: " + page.getNumberOfElements());
    }
}
