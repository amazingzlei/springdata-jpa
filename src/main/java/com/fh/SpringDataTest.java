package com.fh;

import com.fh.entity.Person;
import com.fh.resporsity.PersonRepsotory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class SpringDataTest {


	private ApplicationContext ctx = null;
	private PersonRepsotory personRepsotory = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		personRepsotory = ctx.getBean(PersonRepsotory.class);
	}


	@Test
	public void testHelloWorldSpringData(){
		Person person = personRepsotory.getByName("A");
		System.out.println(person);
	}

	@Test
	public void testKeyWord(){
		List<Person> personList = personRepsotory.findByNameEndingWithAndAgeLessThan("A", 23);
		System.out.println(personList);
	}

	@Test
	public void testJiLian(){
		List<Person> personList = personRepsotory.readByAddressIdLessThan(2);
		System.out.println(personList);
	}

	@Test
	public void testJiLian2(){
		List<Person> personList = personRepsotory.readByAddress_IdLessThan(2);
		System.out.println(personList);
	}
}
