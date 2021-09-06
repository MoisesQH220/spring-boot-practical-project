package com.projects.clients.repository;

import com.projects.clients.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> {
  
  Client findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);
}
