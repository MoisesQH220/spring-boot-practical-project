package com.projects.clients.repository;

import com.projects.clients.model.entity.Client;
import com.projects.clients.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OfferRepository extends JpaRepository<Offer, Long> {
  
  @Query(value = "select * from offer o \n" +
    "inner join mobile_line ml on o.mobile_line_id = ml.id \n" +
    "where  o.start_date >= STR_TO_DATE(:startDate,'%Y-%m-%d') \n" +
    "and  o.end_date <= STR_TO_DATE(:endDate,'%Y-%m-%d')\n" +
    "and ml.status = 'Activo' \n" +
    "order by o.end_date desc limit 1;", nativeQuery = true)
  Offer findByStartDateAndEndDate(String startDate, String endDate);
  
  
}
