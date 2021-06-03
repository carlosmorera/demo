package com.challenge.demo;

import com.challenge.demo.apirest.entity.Person;
import com.challenge.demo.apirest.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

    @Test
    void createPerson() throws ParseException {
        Person person = new Person(1, "name", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));

        assertEquals(1, person.getId());
        assertEquals("name", person.fullName);
    }

    @Test
    void updatePerson() throws ParseException {
        Person person = new Person(1, "name", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        person.setFullName("New Name");

        assertEquals(1, person.getId());
        assertEquals("New Name", person.fullName);
    }


    @Test
    void getPerson() throws ParseException {
        Person person = new Person(1, "name", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        PersonService service = mock(PersonService.class);
        when(service.findById(1)).thenReturn(person);
        Person personTest = service.findById(1);

        assertEquals(1, personTest.getId());
        assertEquals("name", personTest.fullName);

    }

    @Test
    void getPeople() throws ParseException {
        Person person = new Person(1, "name", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        Person person2 = new Person(2, "SECOND name", new SimpleDateFormat("dd/MM/yyyy").parse("11/10/2000"));
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person2);
        PersonService service = mock(PersonService.class);
        when(service.findAll()).thenReturn(list);
        List<Person> people = service.findAll();

        assertEquals(2, people.size());
    }

}
