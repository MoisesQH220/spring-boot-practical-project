package com.projects.clients.model.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse implements Serializable {
  
  private static final long serialVersionUID = -2489850791495320L;
  
  @ApiModelProperty(value = "Código de oferta", example = "OF1", position = 1)
  private String code;
  
  @ApiModelProperty(value = "Descripción de oferta", example = "Oferta Simple", position = 2)
  private String description;
  
  @ApiModelProperty(value = "Fecha de inicio", example = "2021-09-05", position = 3)
  private String startDate;
  
  @ApiModelProperty(value = "Fecha de fin", example = "2022-09-21", position = 4)
  private String endDate;
  
}
