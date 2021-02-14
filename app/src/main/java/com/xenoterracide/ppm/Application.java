/* Copyright © 2020 Caleb Cushing. All rights reserved */
package com.xenoterracide.ppm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// CHECKSTYLE:OFF HideUtilityClassConstructor FinalClass
@SpringBootApplication
public class Application {

  // CHECKSTYLE:ON

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
