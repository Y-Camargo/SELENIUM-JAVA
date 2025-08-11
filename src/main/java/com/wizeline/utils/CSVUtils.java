package com.wizeline.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class CSVUtils {
  private CSVUtils() {}

  public static List<String> readAllLines(Path path) throws IOException {
    return Files.readAllLines(path);
  }

  public static void writeLines(Path path, List<String> lines) throws IOException {
    Files.write(path, lines);
  }
}
