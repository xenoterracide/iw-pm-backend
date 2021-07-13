/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.user.model;

import com.xenoterracide.ppm.user.model.converter.AuthnIdentityConverter;
import com.xenoterracide.ppm.util.modelgraph.AbstractGraphEntity;
import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class User extends AbstractGraphEntity {

  @CompositeProperty(converter = AuthnIdentityConverter.class)
  private final AuthnIdentity identity;

  @CreatedDate
  private final Instant created;

  public User(AuthnIdentity identity, Instant created) {
    this.identity = identity;
    this.created = created;
  }

  public AuthnIdentity getIdentity() {
    return identity;
  }

  public Instant getCreated() {
    return created;
  }
}
