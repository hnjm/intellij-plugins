package com.jetbrains.cidr.cpp.embedded.platformio.project;

import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class SourceTemplate {
  public static final SourceTemplate NONE = new SourceTemplate("", "");
  public static final SourceTemplate GENERIC = new SourceTemplate(
    "main.c",
    """
      int main() {
      // write your code here
      }
      """);

  public static final SourceTemplate ARDUINO = new SourceTemplate(
    "main.cpp",
    """
      #include <Arduino.h>
      void setup() {
      // write your initialization code here
      }

      void loop() {
      // write your code here
      }""");
  private final String fileName;
  private final byte[] content;

  private SourceTemplate(String fileName, String content) {
    this.fileName = fileName;
    this.content = content.getBytes(Charsets.US_ASCII);
  }

  public @NotNull String getFileName() {
    return fileName;
  }

  public byte @NotNull [] getContent() {
    return content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SourceTemplate template = (SourceTemplate)o;

    if (!fileName.equals(template.fileName)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return fileName.hashCode();
  }

  public static SourceTemplate getByFrameworkName(@NotNull String platformName) {
    if ("arduino".equalsIgnoreCase(platformName)) return ARDUINO;
    return GENERIC;
  }

  public static SourceTemplate getByFrameworkName(@NotNull Collection<String> platformsNames) {
    if (platformsNames.contains("arduino")) return ARDUINO;
    return GENERIC;
  }
}
