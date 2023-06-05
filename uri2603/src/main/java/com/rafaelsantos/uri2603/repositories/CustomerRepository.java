package com.rafaelsantos.uri2603.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaelsantos.uri2603.dto.CustomerMinDTO;
import com.rafaelsantos.uri2603.entities.Customer;
import com.rafaelsantos.uri2603.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query(nativeQuery = true, value = "SELECT name, street "
			+ "FROM customers "
			+ "WHERE city= :city")
	List<CustomerMinProjection> sqlSearch(String city);
	
	@Query("SELECT new com.rafaelsantos.uri2603.dto.CustomerMinDTO(obj.name, obj.street) "
			+ "FROM Customer obj "
			+ "WHERE obj.city= :city")
	List<CustomerMinDTO> jpqlSearch(String city);
}
