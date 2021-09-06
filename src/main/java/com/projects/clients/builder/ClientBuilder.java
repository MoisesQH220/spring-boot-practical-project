package com.projects.clients.builder;

import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.model.api.MobileLineResponse;
import com.projects.clients.model.api.OfferResponse;
import com.projects.clients.model.entity.Client;
import com.projects.clients.model.entity.MobileLine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.projects.util.DateUtil.toFormatDate;

@Component
public class ClientBuilder {
  
  public ClientResponse toClientResponse(Client client) {
    return ClientResponse
      .builder()
      .fullName(client.getFullName())
      .documentType(client.getDocumentType())
      .documentNumber(client.getDocumentNumber())
      .birthDate(toFormatDate(client.getBirthDate()))
      .mobileLines(toClientMobileLines(client))
      .build();
  }
  
  private List<MobileLineResponse> toClientMobileLines(Client client) {
    return client.getMobileLines().stream()
      .map(mobileLine -> MobileLineResponse.builder()
        .cellPhoneNumber(mobileLine.getCellPhoneNumber())
        .status(String.valueOf(mobileLine.getStatus()))
        .type(String.valueOf(mobileLine.getType()))
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
        .startDate(toFormatDate(offer.getStartDate()))
        .endDate(toFormatDate(offer.getEndDate()))
        .build())
      .collect(Collectors.toList());
  }
}
