package com.example.study.service;

import com.example.study.PersonInterface.PersonInterface;
import com.example.study.entity.PersonEntity;
import com.example.study.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mapping.AccessOptions;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Primary
public class PersonService implements PersonInterface {


    @Value("${study.name.demo}")
    private String appname;

    @Autowired
    private PersonRepository personRepository;

    @Async
    public CompletableFuture<List<PersonEntity>> getListOfPersons(String dept, Integer empId) {

            return CompletableFuture.completedFuture(personRepository.getAllPersons());

    }

    /// @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public void save(PersonEntity person) {
        PersonEntity response = personRepository.save(person);
    }

    @Override
    public PersonEntity updatePerson(PersonEntity person) {

      PersonEntity toBeUpdated =   personRepository.getByDeptAndEmpId(person.getDept(), person.getEmpId());
      toBeUpdated.setName(person.getName());
      toBeUpdated.setDept(person.getDept());
      toBeUpdated.setAge(person.getAge());
      toBeUpdated.setDesign(person.getDesign());
      personRepository.save(toBeUpdated);
      return toBeUpdated;
    }

    @Override
    public PersonEntity deletePerson(Integer employeeId) {
        PersonEntity deletePerson =   personRepository.getByEmployeeId(employeeId);
        ///Valdations
        personRepository.delete(deletePerson);
        return deletePerson;
    }


}

