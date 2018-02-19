package com.cruizg93.virtualbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cruizg93.virtualbook.model.Client;
import com.cruizg93.virtualbook.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value ="/clients/registration", method=RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Client client = new Client();
		modelAndView.addObject("client",client);
		modelAndView.setViewName("crud/clientForm");
		return modelAndView;
	}
	
	@RequestMapping( value="/clients/registration", method = RequestMethod.POST)
	public ModelAndView createNewClient( @Valid Client client, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		//TODO donde deberia ir esta validacion
		if(client.getCompanyName()!=null) {
			if ( clientService.findClientByCompanyName(client.getCompanyName()) != null) {
				bindingResult
					.rejectValue("companyName", "error.companyName",
							"There is already a client registered with this company name");
			}
		}else {
			if ( clientService.findClientByFullName(client.getName(), client.getLastName()) != null ) {
				bindingResult
					.rejectValue("companyName", "error.name",
							"There is already a client registered with this name and last name");
			}
		}
		
		if (!bindingResult.hasErrors()) {
			clientService.saveClient(client);
			modelAndView.addObject(MyGeneric.SUCCESSMESSAGE, "Client has been registered successfully");
			modelAndView.addObject("client",new Client());
		}
		
		modelAndView.setViewName("registration");
		return modelAndView;
	}
}



