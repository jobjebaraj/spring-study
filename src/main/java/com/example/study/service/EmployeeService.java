package com.example.study.service;

import com.example.study.PersonInterface.PersonInterface;
import com.example.study.entity.PersonEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeService implements PersonInterface {
    @Override
    public CompletableFuture<List<PersonEntity>> getListOfPersons(String input, Integer empId) {
        return null;
    }

    @Override
    public void save(PersonEntity person) {

    }

    @Override
    public PersonEntity updatePerson(PersonEntity person) {
        return null;
    }

    @Override
    public PersonEntity deletePerson(Integer employeeId) {
        return null;
    }
}
