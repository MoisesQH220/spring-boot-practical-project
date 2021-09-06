package com.projects.config.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ErrorException extends RuntimeException {

  public ErrorException(String message) {
    super(message);
  }
}
