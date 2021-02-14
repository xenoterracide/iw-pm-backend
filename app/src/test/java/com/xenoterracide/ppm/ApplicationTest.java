/* Copyright © 2020 Caleb Cushing. All rights reserved */
package com.xenoterracide.ppm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTest {

  @Test
  void healthCheck(@Autowired WebTestClient webClient) {
    webClient.get().uri("/actuator/health").exchange().expectStatus().isOk();
  }
}
