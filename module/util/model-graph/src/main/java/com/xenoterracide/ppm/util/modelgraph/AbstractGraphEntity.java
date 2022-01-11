/*
 * Copyright © 2021-2022 Caleb Cushing.
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
import org.springframework.data.annotation.Version;

public abstract class AbstractGraphEntity implements Identifiable<UUID> {

  @Id
  private final UUID id;

  @Version
  private final Long version;

  public AbstractGraphEntity() {
    this(UuidCreator.getTimeOrderedWithHash(), 0);
  }

  @PersistenceConstructor
  AbstractGraphEntity(UUID id, long version) {
    this.id = id;
    this.version = version;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(this.getId(), this.version);
  }

  @Override
  public UUID getId() {
    return this.id;
  }

  @Override
  public final boolean equals(Object that) {
    if (!(that instanceof AbstractGraphEntity)) {
      return false;
    }
    return (
      Objects.equals(this.getId(), ((AbstractGraphEntity) that).getId()) &&
      Objects.equals(this.version, ((AbstractGraphEntity) that).version)
    );
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(
      this,
      ToStringStyle.MULTI_LINE_STYLE
    );
  }
}
