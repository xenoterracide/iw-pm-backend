/*
 * Copyright © 2020-2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
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
