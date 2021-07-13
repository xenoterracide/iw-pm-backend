/*
 * Copyright © 2020-2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.authn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class OIDCTestController {

  private final Logger log = LogManager.getLogger(this.getClass());

  @GetMapping
  @NonNull
  String index(@Nullable Authentication details) {
    log.info("{}", details);
    var name = details != null ? details.getName() : "world";
    return "Hello, " + name;
  }
}
