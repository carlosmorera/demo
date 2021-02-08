package com.challenge.demo.apirest.dao;




import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.challenge.demo.apirest.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PersonDAOImpl implements PersonDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Person> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Person> theQuery = currentSession.createQuery("from Person", Person.class);

        List<Person> people = theQuery.getResultList();

        return people;

    }

    @Override
    public Person findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Person person = currentSession.get(Person.class, id);

        return person;
    }
    @Override
    @Transactional
    public void save(Person person) {
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println(person.getId());
        System.out.println(person.fullName);
        System.out.println(person.birth);
        System.out.println("-------------");
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(person);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Person> theQuery = currentSession.createQuery("delete Person where id=:id");

        theQuery.setParameter("id", id);
        theQuery.executeUpdate();

    }


}