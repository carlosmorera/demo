package com.challenge.demo.apirest.service;

import com.challenge.demo.apirest.entity.Person;

import java.util.List;

public interface  PersonService {
    public List<Person> findAll();

    public Person findById(int id);

    public void save(Person person);

    public void deleteById(int id);
}
