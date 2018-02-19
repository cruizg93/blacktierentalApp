package com.cruizg93.virtualbook.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruizg93.virtualbook.model.Client;
import com.cruizg93.virtualbook.repository.ClientRepository;
import com.cruizg93.virtualbook.repository.UserRepository;

@Service("clientService")
public class ClientServiceImpl extends MainService implements ClientService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client findClientByFullName(String name, String lastName) {
		return clientRepository.findByNameAndLastName(name, lastName);
	}

	@Override
	public Client findClientByEmail(String email) {
		return clientRepository.findByEmail(email);
	}

	@Override
	public void saveClient(Client client) {
		client.setStatus(1);
		client.setCreatedDate(new Date());
//		client.setCreatedBy(this.loggedUser);
		clientRepository.save(client);
	}

	@Override
	public Client findClientByCompanyName(String companyName) {
		return clientRepository.findByCompanyName(companyName);
	}

}
