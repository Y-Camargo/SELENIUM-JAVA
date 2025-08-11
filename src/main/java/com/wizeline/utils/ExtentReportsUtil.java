package com.wizeline.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExtentReportsUtil {
  private ExtentReportsUtil() {}

  public static String timestamp() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
  }
}
