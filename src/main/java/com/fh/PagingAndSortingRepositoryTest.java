package com.fh;

import com.fh.entity.Person;
import com.fh.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

public class PagingAndSortingRepositoryTest {
    private ApplicationContext ctx = null;
    private PersonService personService = null;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personService = ctx.getBean(PersonService.class);
    }

    @Test
    public void test01(){
        Page<Person> personPage = personService.findSortAndPage();
        System.out.println("总页数:"+personPage.getTotalPages());
        System.out.println("总记录数:"+personPage.getTotalElements());
        System.out.println("当前页:"+personPage.getNumber());
        System.out.println("当前页记录数:"+personPage.getNumberOfElements());
        System.out.println("内容:"+personPage.getContent());
    }
}
