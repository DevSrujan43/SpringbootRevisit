package com.springboot.demo.personInfo.personService;

import com.springboot.demo.personInfo.personDao.personRepository;
import com.springboot.demo.personInfo.personModel.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class personServiceImpl implements personService {
    @Autowired
    private personRepository personRepository;
    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersonData(){
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        try {
            Optional<Person> personData = personRepository.findById(id);
            if(personData.isPresent()) {
                return personData.get();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("No Person found with : {} " + id);
        }
        return null;
    }


    @Override
    public Person updatePersonDetails(Person person, int id) {
        Optional<Person> personExists = personRepository.findById(id);
        if(personExists.isPresent()) {
            personExists.get().setFirstName(person.getFirstName());
            personExists.get().setLastName(person.getLastName());
            personExists.get().setCity(person.getCity());
            personExists.get().setAddress(person.getAddress());
            personRepository.save(personExists.get());
        }
        return personExists.get();
    }

    @Override
    public void deletePersonById(int id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            personRepository.deleteById(id);
        }
    }
}
