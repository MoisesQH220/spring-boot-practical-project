package com.projects.clients.business;

import com.projects.clients.model.api.ClientResponse;

public interface ClientService {
  
  ClientResponse findPersonInformation(String documentType, String documentNumber);
}
