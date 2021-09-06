# Implementation Notes

### Acerca de la funcionalidad expuesta
Esta funcionalidad permite obtener información de una persona por su tipo de documento y número de documento, el cual nos retornará la información necesaria de una persona que será mostrada en listas desplegables en el portal web del BPM.
<br/>


### URI de acceso a la API
| Método | URI |
|--------|-------------|
|GET |  /api/clients?documentType={documentType}&documentNumber={documentNumber}

<br/>

### Precondiciones para el consumo de esta versión de la API
No Aplica.

<br/>

### Headers
| Header       | Ejemplo                              | Obligatorio |
| ------------ | ------------------------------------ | ----------- |
| Request-ID   | 550e8400-e29b-41d4-a716-446655440000 | S           |
| request-date | 2019-07-11T01:30:00.000-05:00        | S           |
| app-code     | APP                                  | S           |
| caller-name  | spring-boot-practical-project        | S           |

<br/>

### Query parameters válidos en esta versión de la API
| Query param    | Tipo de dato | Descripción          | Valores permitidos |
| -------------- | ------------ | -------------------- | ------------------ |
| documentType   | String       | Tipo de documento.   | -                  |
| documentNumber | String       | Número de documento. | -                  |

<br/>

### Usos válidos de query parameters

| Resultado esperado                       | Path param | Query parameters requerido   | Query parameters opcionales | Query param extrafields |
| ---------------------------------------- | ---------- | ---------------------------- | --------------------------- | ----------------------- |
| Se obtienen informacion de la persona. | -          | documentType, documentNumber | -                           | -                       |

<br/>

### Variantes válidas del payload (cuerpo del mensaje)
No aplica.

<br/>

### Lista de valores usados en esta versión de la API 
Para el queryParam __'documentType'__ se encuentran los posibles valores en la siguiente tabla :
<br/>

| Valor       | Descripción     |                     
|-------------|-----------------|
|   1       | DNI|
|   2       | CARNET DE EXTRANJERIA|

<br/>

### Código de errores del Servicio en esta versión de la API
No aplica.

<br/>