package com.projects.clients.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"offer\"")
public class Offer implements Serializable {
  
  private static final long serialVersionUID = 4855036044829413041L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private Integer id;
  
  @Column(name = "code", nullable = false)
  private String code;
  
  @Column(name = "description", nullable = false)
  private String description;
  
  @Column(name = "start_date")
  private String startDate;
  
  @Column(name = "end_date")
  private String endDate;
  
  @Column(name = "date_create")
  private Date dateCreate;
  
  @Column(name = "username_create")
  private String usernameCreate;
  
  @Column(name = "date_update")
  private Date dateUpdate;
  
  @Column(name = "username_update")
  private String usernameUpdate;
  
}
