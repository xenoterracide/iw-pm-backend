/* Copyright © 2020 Caleb Cushing. All rights reserved */
package com.xenoterracide.usersettings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

// CHECKSTYLE:OFF HideUtilityClassConstructor FinalClass
@ActiveProfiles("dev")
@SpringBootApplication
public class TestApplication {

  // CHECKSTYLE:ON

  public static void main( String[] args ) {
    SpringApplication.run( TestApplication.class, args );
  }
}

