package com.wizeline.utils;

public final class TestUtils {
  private TestUtils() {}

  public static boolean isNullOrEmpty(String s) {
    return s == null || s.isEmpty();
  }
}
