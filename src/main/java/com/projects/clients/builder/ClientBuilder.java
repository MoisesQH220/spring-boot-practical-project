package com.projects.clients.builder;

import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.model.api.MobileLineResponse;
import com.projects.clients.model.api.OfferResponse;
import com.projects.clients.model.entity.Client;
import com.projects.clients.model.entity.MobileLine;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ClientBuilder {
  
  public ClientResponse toClientResponse(Client client) {
    return ClientResponse
      .builder()
      .fullName(client.getFullName())
      .documentType(client.getDocumentType())
      .documentNumber(client.getDocumentNumber())
      .birthDate(client.getBirthDate())
      .mobileLines(toClientMobileLines(client))
      .build();
  }
  
  private List<MobileLineResponse> toClientMobileLines(Client client) {
    return client.getMobileLines().stream()
      .map(mobileLine -> MobileLineResponse.builder()
        .cellPhoneNumber(mobileLine.getCellPhoneNumber())
        .status(mobileLine.getStatus())
        .type(mobileLine.getType())
        .planName(mobileLine.getPlanName())
        .offers(toOffers(mobileLine))
        .build())
      .collect(Collectors.toList());
  }
  
  private List<OfferResponse> toOffers(MobileLine mobileLine) {
    return mobileLine.getOffers().stream()
      .map(offer -> OfferResponse.builder()
        .code(offer.getCode())
        .description(offer.getDescription())
        .startDate(offer.getStartDate())
        .endDate(offer.getEndDate())
        .build())
      .collect(Collectors.toList());
  }
}
