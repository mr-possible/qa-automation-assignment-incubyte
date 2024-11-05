package com.incubyte.utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PasswordGenerator {

  private static final Faker faker = new Faker();

  private PasswordGenerator() {
  }

  public static String generateSecurePassword(int minLength, int maxLength) {
    String lowercase = faker.regexify("[a-z]{2}");
    String uppercase = faker.regexify("[A-Z]{2}");
    String digits = faker.regexify("[0-9]{2}");
    String specialChars = faker.regexify("[@#&$*!]{2}");

    // Add them to a list for shuffling
    List<String> passwordCharacters = new ArrayList<>();
    passwordCharacters.add(lowercase);
    passwordCharacters.add(uppercase);
    passwordCharacters.add(digits);
    passwordCharacters.add(specialChars);

    // Shuffle to randomize the order of character types
    Collections.shuffle(passwordCharacters);

    // Combine to form the initial part of the password
    StringBuilder password = new StringBuilder(String.join("", passwordCharacters));

    // If the generated password is shorter than minLength, fill in with random characters
    int finalLength = minLength + faker.random().nextInt(maxLength - minLength + 1);
    while (password.length() < finalLength) {
      password.append(faker.regexify("[a-zA-Z0-9@#&$*!]"));
    }

    return password.toString();
  }
}
