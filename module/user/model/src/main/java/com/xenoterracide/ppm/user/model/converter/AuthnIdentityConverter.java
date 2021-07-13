/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.user.model.converter;

import com.xenoterracide.ppm.user.model.AuthnIdentity;
import com.xenoterracide.ppm.util.modelgraph.AbstractMapToObjectConverter;

public class AuthnIdentityConverter
  extends AbstractMapToObjectConverter<AuthnIdentity> {

  AuthnIdentityConverter() {
    super(AuthnIdentity.class);
  }
}
