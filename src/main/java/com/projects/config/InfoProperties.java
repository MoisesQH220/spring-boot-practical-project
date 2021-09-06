package com.projects.config;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@Getter
public class InfoProperties {
  
  @Value("${info.project.version}")
  private String version;
  
  @Value("${info.project.title}")
  private String tittle;
  
  @Value("${info.project.description}")
  private String description;
}
