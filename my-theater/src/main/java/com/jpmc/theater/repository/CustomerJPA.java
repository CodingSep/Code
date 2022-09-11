package com.jpmc.theater.repository;


import com.jpmc.theater.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJPA extends JpaRepository<Customer,Long> {
}
