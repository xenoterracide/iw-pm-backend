/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import com.fasterxml.uuid.Generators;
import com.xenoterracide.ppm.util.model.Identifiable;

import java.util.UUID;

public abstract class AbstractGraphEntity implements Identifiable {
  private final UUID id;

  public AbstractGraphEntity() {
    this.id = Generators.timeBasedGenerator().generate();
  }

  @Override
  public UUID getId() {
    return this.id;
  }
}
