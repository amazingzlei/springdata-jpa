package com.fh;

import com.fh.entity.Person;
import com.fh.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrudRepositoryTest {

    private ApplicationContext ctx = null;
    private PersonService personService = null;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personService = ctx.getBean(PersonService.class);
    }

    @Test
    public void test01(){
        List<Person> personList = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setId(4);
        person1.setName("DA");
        person1.setAge(22);
        person1.setAddressId(1);

        Person person2 = new Person();
        person2.setId(5);
        person2.setName("EA");
        person2.setAge(23);
        person2.setAddressId(1);

        Person person3 = new Person();
        person3.setId(6);
        person3.setName("FA");
        person3.setAge(24);
        person3.setAddressId(2);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        System.out.println(personService.saveList(personList));
    }

    @Test
    public void test02(){
        System.out.println(personService.count());
    }

    @Test
    public void test03(){
        System.out.println(personService.find(3));
    }
}
