package com.challenge.demo.apirest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Person")

public class Person {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="full_name")
    public String fullName;

    @Column(name="birth")
    @UpdateTimestamp
    public Date birth;

    public Person() {}

    public Person(int id, String fullName, Date birth) {
        this.id = id;
        this.fullName = fullName;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Date getBirth() {
        return this.birth;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
