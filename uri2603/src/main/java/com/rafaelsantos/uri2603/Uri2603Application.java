package com.rafaelsantos.uri2603;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelsantos.uri2603.dto.CustomerMinDTO;
import com.rafaelsantos.uri2603.projections.CustomerMinProjection;
import com.rafaelsantos.uri2603.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2603Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2603Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerMinProjection> list = repository.sqlSearch("Porto Alegre");
		List<CustomerMinDTO> sqlResult = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());

		for (CustomerMinDTO obj : sqlResult) {
			System.out.println(obj);
		}
	}

}
