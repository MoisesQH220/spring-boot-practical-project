package com.projects.clients.business.impl;

import com.projects.clients.builder.ClientBuilder;
import com.projects.clients.business.ClientService;
import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.model.entity.Client;
import com.projects.clients.repository.ClientRepository;
import com.projects.config.exception.ErrorException;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
  
  private final ClientRepository clientRepository;
  private static final Logger logger = LogManager.getLogger(ClientService.class);
  
  @Override
  public ClientResponse findPersonInformation(String documentType, String documentNumber) {
    Client client = clientRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);
    if (Objects.isNull(client)) {
      throw new ErrorException("Not found person.");
    }
    logger.info("Customer information was found.");
    return ClientBuilder.toClientResponse(client);
  }
  
  
  
  
}