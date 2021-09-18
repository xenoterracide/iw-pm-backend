/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import com.github.f4b6a3.uuid.UuidCreator;
import com.xenoterracide.ppm.util.model.Identifiable;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public abstract class AbstractGraphEntity implements Identifiable<UUID> {

  @Id
  private final UUID id;

  public AbstractGraphEntity() {
    this(UuidCreator.getTimeOrderedWithHash());
  }

  @PersistenceConstructor
  AbstractGraphEntity(UUID id) {
    this.id = id;
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(this.getId());
  }

  @Override
  public UUID getId() {
    return this.id;
  }

  @Override
  public final boolean equals(Object obj) {
    if (!(obj instanceof AbstractGraphEntity)) {
      return false;
    }
    return Objects.equals(getId(), ((AbstractGraphEntity) obj).getId());
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(
      this,
      ToStringStyle.MULTI_LINE_STYLE
    );
  }
}
