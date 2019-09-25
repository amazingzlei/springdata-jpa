package com.fh;

import com.fh.resporsity.PersonRepsotory;
import com.fh.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ModifyingTest {
    private ApplicationContext ctx = null;
    private PersonService personService = null;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personService = ctx.getBean(PersonService.class);
    }

    @Test
    public void test01(){
        System.out.println(personService.update(1, 25));
    }
}
