package com.example.study.service;

import com.example.study.PersonInterface.PersonInterface;
import com.example.study.entity.PersonEntity;
import com.example.study.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PersonService implements PersonInterface {



      @Autowired
      private PersonRepository personRepository;

      @Async
      public CompletableFuture<List<PersonEntity>> getListOfPersons() {
            return CompletableFuture.completedFuture(personRepository.getAllPersons());
       }

      /// @Transactional(isolation = Isolation.READ_UNCOMMITTED)
      @Override
      public void save(PersonEntity person) {
           PersonEntity response = personRepository.save(person);
      }
}

