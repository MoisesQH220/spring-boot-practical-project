package com.projects.util;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateUtil {
  
  public static String toFormatDate(String birthDate) {
    if (birthDate == null) return null;
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(Constants.INPUT_DATE_FORMAT, Locale.ENGLISH);
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT, Locale.ENGLISH);
    return outputFormatter.format(LocalDateTime.parse(birthDate, inputFormatter));
  }
}