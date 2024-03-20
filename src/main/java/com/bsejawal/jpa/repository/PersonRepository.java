package com.bsejawal.jpa.repository;

import com.bsejawal.jpa.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    @Modifying
    @Query(value = "INSERT INTO Person (personId,name, email, phone, gender, dob) VALUES (:personId,:name, :email, :phone, :gender, :dob)")
    @Transactional
    int insert(@Param("personId") String personId, @Param("name") String name, @Param("email") String email, @Param("phone") String phone, @Param("gender") String gender, @Param("dob") Date dob);
List<Person> findAllByCreatedAtAfter(Instant instant);


}