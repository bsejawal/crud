package com.bsejawal.jpa.repository;

import com.bsejawal.jpa.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    @Query("SELECT p FROM Person p WHERE p.name=?1")
    List<Person> find30DaysPersons(String reason);

    @Modifying
    @Query(value = "INSERT INTO Person (personId,name, email, phone, gender, dob) VALUES (:personId,:name, :email, :phone, :gender, :dob)")
    @Transactional
    int insert(@Param("personId") String personId, @Param("name") String name, @Param("email") String email, @Param("phone") String phone, @Param("gender") String gender, @Param("dob") Date dob);

    @Query("SELECT p FROM Person p WHERE p.createdAt >= :startDate")
    List<Person> findAllCreatedAfter(@Param("startDate") Instant startDate);

}