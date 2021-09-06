package com.projects.clients.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"mobile_line\"")
public class MobileLine implements Serializable {
  
  private static final long serialVersionUID = 5882066997624302700L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private Long id;
  
  @Column(name = "cell_phone_number", nullable = false)
  private String cellPhoneNumber;
  
  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;
  
  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private Type type;
  
  @Column(name = "plan_name")
  private String planName;
  
  @Column(name = "date_create")
  private Date dateCreate;
  
  @Column(name = "username_create")
  private String usernameCreate;
  
  @Column(name = "date_update")
  private Date dateUpdate;
  
  @Column(name = "username_update")
  private String usernameUpdate;
  
  @OneToMany(mappedBy = "mobileLine", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  private List<Offer> offers;
  
  @ManyToOne(fetch = FetchType.LAZY)
  private Client client;
  
}
