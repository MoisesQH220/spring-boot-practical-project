package com.projects.util;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class Constants {
  public static final String MS_TAG_NAME = "Clients";
  public static final String MS_TAG_DESC = "Gestiona la información de los clientes de Telefónica del Perú";
  public static final String GET = "GET";
  public static final String CLIENT_CLASSPATH = "classpath:swagger/notes/api-get-clients.md";

  public static final String REG_DOC_TYPE = "[0-9]{1,1}";
  public static final String REG_DOC_NUM = "[0-9]{8,12}";

  public static final String INPUT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
  public static final String DATE_FORMAT = "yyyy-MM-dd";

  public static final String GET_CLIENT_DESC = "Funcionalidad que permite obtener la informaci\u00f3n de una persona por tipo y n\u00famero de documento";

  public static final String DOCUMENT_NUMBER = "El dato documentNumber debe ser num\u00e9rico de 8 a 12 d\u00edgitos.";
  public static final String DOCUMENT_TYPE = "El dato documentType debe ser num\u00e9rico de un solo d\u00edgito.";
  
}
