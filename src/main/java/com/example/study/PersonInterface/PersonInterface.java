package com.example.study.PersonInterface;


import com.example.study.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public interface PersonInterface {

    public CompletableFuture<List<PersonEntity>> getListOfPersons();
    public void save(PersonEntity person) ;
}
