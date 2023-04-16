package com.springboot.demo.personInfo.personController;

import com.springboot.demo.personInfo.personModel.Person;
import com.springboot.demo.personInfo.personService.personService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class personController {
    @Autowired
    private personService personService;
    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        try {
            Person personDetails = personService.savePerson(person);
            return new ResponseEntity<>(personDetails, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/GetDetails")
    public ResponseEntity<List<Person>> getAllPersonsData(){
        try {
            List<Person> getAllPersonsData = personService.getAllPersonData();
            return new ResponseEntity<>(getAllPersonsData,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<Person> getPersonById(@RequestParam int id) {
        try {
            Person personFoundById = personService.getPersonById(id);
            return new ResponseEntity<>(personFoundById,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> updatePersonDetails(@PathVariable("id") int id, @RequestBody Person person) {
        try {
            Person personFoundById = personService.updatePersonDetails(person,id);
            return new ResponseEntity<>(personFoundById,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> deletePersonById(@RequestParam int id) {
        try {
             personService.deletePersonById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
