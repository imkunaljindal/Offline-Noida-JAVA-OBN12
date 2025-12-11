package com.example.zwigato.dao;

import com.example.zwigato.model.Customer;
import com.example.zwigato.utility.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

//    @Query(value = "select * from customer where gender=:g" ,nativeQuery = true)
//    List<Customer> findByGender(String g);


    @Query(value = "select c from Customer c where c.gender=:g")
    List<Customer> findByGender(Gender g);
}
