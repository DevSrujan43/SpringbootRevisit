package com.springboot.demo.personInfo.personDao;

import com.springboot.demo.personInfo.personModel.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface personRepository extends JpaRepository<Person,Integer> {
}
