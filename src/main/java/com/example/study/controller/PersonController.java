package com.example.study.controller;

import com.example.study.PersonInterface.PersonInterface;
import com.example.study.config.PersonConfiguration;
import com.example.study.entity.PersonEntity;
import com.example.study.service.EmployeeService;
import com.example.study.service.PersonService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@Scope("prototype")
public class PersonController {
/// CRUD OPERATIONS.

    @Autowired
    PersonInterface personService;


    @Autowired
    PersonInterface employeeService;

    public PersonController() {

        System.out.println(" Controller with Prototype");
    }

    @Autowired
    PersonConfiguration personConfiguration;

    Map<Integer, PersonEntity> personDB = new HashMap<>();

    // to Get the User Id given from the request
    @GetMapping
    public String getUser(Principal principal) {
        return principal.getName();
    }
    @GetMapping("/person")
    public List<PersonEntity> getPersonName(@RequestParam("dept") String dept,
                                            @RequestParam("empId") Integer empId) throws ExecutionException, InterruptedException {

        return personService.getListOfPersons(dept, empId).get();
    }

    @PostMapping("/createPerson")
    public PersonEntity createPerson(@RequestBody Optional<PersonEntity> person) throws ExecutionException, InterruptedException {
        System.out.println( employeeService.getListOfPersons("HR", 2000).get());
        if(person.isPresent()) {
            person.get().setDept(personConfiguration.getDeptWithId());
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


     @PostConstruct
     public void init() throws Exception
     {
         System.out.println(
                 "Bean Person Controller has been "
                         + "instantiated and I'm the "
                         + "init() method");
     }

    // Annotate this method to execute it
    // when Spring container is closed
    @PreDestroy
    public void destroy() throws Exception
    {
        System.out.println(
                "Container has been closed "
                        + "and I'm the destroy() method");
    }

}
