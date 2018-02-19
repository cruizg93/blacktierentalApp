package com.cruizg93.virtualbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cruizg93.virtualbook.model.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long>{

	Client findByNameAndLastName(String name, String lastName);
	Client findByEmail(String email);
	Client findByCompanyName(String companyName);
}
