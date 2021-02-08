package com.challenge.demo.controller;


import com.challenge.demo.apirest.entity.Person;
import com.challenge.demo.apirest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/api") // http://127.0.0.1:8080/api/

public class PersonRestController {

    @Autowired
    private PersonService personService;

    //http://127.0.0.1:8080/api/people
    @GetMapping("/people")
    public List<Person> findAll() {
        return personService.findAll();
    }
    //http://127.0.0.1:8080/api/people/id
    @GetMapping("/people/{personId}")
    public Person getPerson(@PathVariable int personId) {
        Person person = personService.findById(personId);
        if (person == null) {
            throw new RuntimeException("Person id not found -" + personId);
        }
        return person;
    }

    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person) {
        person.setId(person.getId());
        personService.save(person);
        return person;

    }

    @PutMapping("/people")
    public Person updatePerson(@RequestBody Person person) {
        personService.save(person);
        return person;
    }

    @DeleteMapping("people/{personId}")
    public String deletePerson(@PathVariable int personId) {
        Person person = personService.findById(personId);
        if (person == null) {
            throw new RuntimeException("Person id not found -" + personId);
        }
        personService.deleteById(personId);
        return "Deleted person id - " + personId;
    }
}
