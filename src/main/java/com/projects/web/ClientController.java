package com.projects.web;

import com.projects.clients.business.ClientService;
import com.projects.clients.business.OfferService;
import com.projects.clients.model.api.ClientResponse;
import com.projects.clients.model.api.OfferResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.projects.util.Constants.GET;
import static com.projects.util.Constants.GET_CLIENT_DESC;
import static com.projects.util.Constants.GET_OFFER_DESC;
import static com.projects.util.Constants.MS_TAG_DESC;
import static com.projects.util.Constants.MS_TAG_NAME;

@RestController
@RequestMapping("api/v1.0")
@Api(tags = MS_TAG_NAME, description = MS_TAG_DESC)
@Validated
@Slf4j
@RequiredArgsConstructor
public class ClientController {
  
  private final ClientService clientService;
  private final OfferService offerService;
  
  @GetMapping(value = "/clients",
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = GET_CLIENT_DESC, response = ClientResponse.class, httpMethod = GET)
  public ClientResponse getPersonInformation(@RequestParam(name = "documentType") String documentType,
                                             @RequestParam(name = "documentNumber") String documentNumber) {
    return clientService.findClientInformation(documentType, documentNumber);
  }
  
  @GetMapping(value = "/offers",
    produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = GET_OFFER_DESC, response = OfferResponse.class, httpMethod = GET)
  public OfferResponse getOffersBYDate(@RequestParam(name = "startDate") String startDate,
                                       @RequestParam(name = "endDate") String endDate) {
    return offerService.findByStartDateAndEndDate(startDate, endDate);
  }
  
}
