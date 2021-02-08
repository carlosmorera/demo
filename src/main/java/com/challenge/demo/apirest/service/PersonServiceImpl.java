package com.challenge.demo.apirest.service;

import com.challenge.demo.apirest.dao.PersonDAO;
import com.challenge.demo.apirest.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> findAll() {
        List<Person> listPersons= personDAO.findAll();
        return listPersons;
    }

    @Override
    public Person findById(int id) {
        Person person = personDAO.findById(id);
        return person;
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);

    }

    @Override
    public void deleteById(int id) {
        personDAO.deleteById(id);
    }

}