package com.projects.clients.business.impl;

import com.projects.clients.builder.ClientBuilder;
import com.projects.clients.business.ClientService;
import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
  
  private final ClientRepository clientRepository;
  private final ClientBuilder clientBuilder;
  
  @Override
  public ClientResponse findPersonInformation(String documentType, String documentNumber) {
    return clientBuilder.toClientResponse(clientRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber));
  }
  
}