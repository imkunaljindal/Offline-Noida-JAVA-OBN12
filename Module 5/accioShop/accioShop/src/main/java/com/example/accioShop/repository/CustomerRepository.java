package com.example.accioShop.repository;

import com.example.accioShop.enums.Gender;
import com.example.accioShop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByGender(Gender gender);

    List<Customer> findByAgeGreaterThanEqual(int age);
}
