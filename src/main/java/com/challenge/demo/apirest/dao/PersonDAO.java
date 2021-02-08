package com.challenge.demo.apirest.dao;

import com.challenge.demo.apirest.entity.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> findAll();

    public Person findById(int id);

    public void save(Person person);

    public void deleteById(int id);
}