package com.cruizg93.virtualbook.service;

import com.cruizg93.virtualbook.model.Client;

public interface ClientService{

	public Client findClientByFullName(String name, String lastName);
	public Client findClientByEmail(String email);
	public Client findClientByCompanyName(String companyName);
	public void saveClient( Client client);
}
