package com.fh;

import com.fh.entity.Person;
import com.fh.resporsity.PersonRepsotory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class QueryTest {

    private ApplicationContext ctx = null;
    private PersonRepsotory personRepsotory = null;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personRepsotory = ctx.getBean(PersonRepsotory.class);
    }

    @Test
    public void test01(){
        Person person = personRepsotory.getMaxIdPerson();
        System.out.println(person);
    }

    @Test
    public void test02(){
        List<Person> personList = personRepsotory.testQueryAnnotationParams1("AA",20);
        System.out.println(personList);
    }

    @Test
    public void test03(){
        long totalCount = personRepsotory.getTotalCount();
        System.out.println(totalCount);
    }
}
