package com.projects.clients.business.impl;

import com.projects.clients.builder.ClientBuilder;
import com.projects.clients.builder.OfferBuilder;
import com.projects.clients.business.ClientService;
import com.projects.clients.business.OfferService;
import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.model.api.OfferResponse;
import com.projects.clients.model.entity.Client;
import com.projects.clients.repository.ClientRepository;
import com.projects.clients.repository.OfferRepository;
import com.projects.config.exception.ErrorException;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {
  
  private final OfferRepository offerRepository;
  private static final Logger logger = LogManager.getLogger(OfferService.class);
  
  
  @Override
  public OfferResponse findByStartDateAndEndDate(String startDate, String endDate) {
    return OfferBuilder.toOfferResponse(offerRepository.findByStartDateAndEndDate(startDate, endDate));
  }
  
  
}