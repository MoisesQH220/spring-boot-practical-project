package com.projects.clients.model.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MobileLineResponse implements Serializable {
  
  private static final long serialVersionUID = -5609559210158256568L;
  
  @ApiModelProperty(value = "Número de teléfono", example = "987551239", position = 1)
  private String cellPhoneNumber;
  
  @ApiModelProperty(value = "Estado de línea móvil", example = "Activo", position = 2)
  private String status;
  
  @ApiModelProperty(value = "Tipo de línea móvil", example = "Postpago", position = 3)
  private String type;
  
  @ApiModelProperty(value = "Nombre de plan de línea móvil", example = "1999-02-21 00:00:00", position = 4)
  private String planName;
  
  @ApiModelProperty(value = "Lista de ofertas de línea móvil", example = "'1'", position = 5)
  private List<OfferResponse> offers;
  
}
