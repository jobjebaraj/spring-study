package com.example.study.controller;

import com.example.study.PersonInterface.PersonInterface;
import com.example.study.entity.PersonEntity;
import com.example.study.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
/// CRUD OPERATIONS.

    @Autowired
    PersonInterface personService;

    Map<Integer, PersonEntity> personDB = new HashMap<>();

    @GetMapping("/person")
    public List<PersonEntity> getPersonName(@RequestParam("dept") String dept,
                                            @RequestParam("empId") Integer empId) throws ExecutionException, InterruptedException {

        return personService.getListOfPersons(dept, empId).get();
    }

    @PostMapping("/createPerson")
    public PersonEntity createPerson(@RequestBody Optional<PersonEntity> person) {
        if(person.isPresent()) {
           personService.save(person.get());
        }
        return person.get();
    }

    @PutMapping("/updatePerson")
    public PersonEntity updatePerson(@RequestBody PersonEntity person) {
        System.out.println(" Person in Controller " + person.toString());
        return personService.updatePerson(person);
    }

     @DeleteMapping
     public PersonEntity deletePerson(@RequestParam("empId") Integer empId) {
       PersonEntity deletedPerson = personService.deletePerson(empId);

     return deletedPerson;
     }

     /**
     @PatchMapping  /// Partial Update
     public Person partialUpdate(Person person) {
     return person;
     }
     */

}
