package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Entites.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
