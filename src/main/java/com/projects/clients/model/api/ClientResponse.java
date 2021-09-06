package com.projects.clients.model.api;

import com.projects.clients.model.entity.MobileLine;
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
public class ClientResponse implements Serializable {
  
  private static final long serialVersionUID = 1691094030628170307L;
  
  @ApiModelProperty(value = "Nombres completos del cliente", example = "Juan Alberto Quispe Herrera", position = 1)
  private String fullName;
  
  @ApiModelProperty(value = "Código asociado al tipo de documento", example = "'1'", position = 2)
  private String documentType;

  @ApiModelProperty(value = "Número documento del cliente", example = "22253698", position = 3)
  private String documentNumber;
  
  @ApiModelProperty(value = "Fecha de nacimiento", example = "1999-02-21 00:00:00", position = 4)
  private String birthDate;

  @ApiModelProperty(value = "Lista de líneas móviles", position = 5)
  private List<MobileLineResponse> mobileLines;
  
}
