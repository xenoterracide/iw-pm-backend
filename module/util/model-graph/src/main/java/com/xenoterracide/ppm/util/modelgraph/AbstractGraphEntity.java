/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import com.github.f4b6a3.uuid.UuidCreator;
import com.xenoterracide.ppm.util.model.Identifiable;
import java.util.UUID;
import org.springframework.data.annotation.Id;

public abstract class AbstractGraphEntity implements Identifiable {

  @Id
  private final UUID id;

  public AbstractGraphEntity() {
    this.id = UuidCreator.getTimeOrderedWithHash();
  }

  @Override
  public UUID getId() {
    return this.id;
  }
}
