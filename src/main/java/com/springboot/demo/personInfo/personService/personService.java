package com.springboot.demo.personInfo.personService;

import com.springboot.demo.personInfo.personModel.Person;

import java.util.List;

public interface personService {
    Person savePerson(Person person);
    List<Person> getAllPersonData();
    Person getPersonById(int id);
    Person updatePersonDetails(Person person, int id);
    void deletePersonById(int id);
}
