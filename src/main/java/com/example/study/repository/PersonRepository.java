package com.example.study.repository;

import com.example.study.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    @Query("from PersonEntity")
    List<PersonEntity> getAllPersons();
    @Query("from PersonEntity p where p.dept=:dept and p.empId=:employeeId")
    PersonEntity getByDeptAndEmpId(String dept, Integer employeeId);

    @Query("from PersonEntity p where p.empId=:employeeId")
    PersonEntity getByEmployeeId(Integer employeeId);



}

