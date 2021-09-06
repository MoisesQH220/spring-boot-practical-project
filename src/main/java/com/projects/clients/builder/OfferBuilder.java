package com.projects.clients.builder;

import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.model.api.MobileLineResponse;
import com.projects.clients.model.api.OfferResponse;
import com.projects.clients.model.entity.Client;
import com.projects.clients.model.entity.MobileLine;
import com.projects.clients.model.entity.Offer;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.projects.util.DateUtil.toFormatDate;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OfferBuilder {
  
  public static OfferResponse toOfferResponse(Offer offer) {
    return OfferResponse.builder()
      .code(offer.getCode())
      .description(offer.getDescription())
      .startDate(toFormatDate(offer.getStartDate()))
      .endDate(toFormatDate(offer.getEndDate()))
      .build();
  }
}
