/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.user.model;

public class AuthnIdentity {

  private final String foreignIdentity;

  public AuthnIdentity(String foreignIdentity) {
    this.foreignIdentity = foreignIdentity;
  }

  public String getForeignIdentity() {
    return foreignIdentity;
  }
}
