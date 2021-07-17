/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import com.xenoterracide.ppm.util.modelgraph.reflect.MapToObject;
import com.xenoterracide.ppm.util.modelgraph.reflect.ObjectToMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.neo4j.driver.Value;
import org.springframework.data.neo4j.core.convert.Neo4jConversionService;
import org.springframework.data.neo4j.core.convert.Neo4jPersistentPropertyToMapConverter;

public abstract class AbstractMapToObjectConverter<T>
  implements Neo4jPersistentPropertyToMapConverter<String, T> {

  private final Class<T> clazz;

  protected AbstractMapToObjectConverter(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public @NonNull Map<String, Value> decompose(
    @NonNull Object property,
    @NonNull Neo4jConversionService neo4jConversionService
  ) {
    return ObjectToMap.convert(property);
  }

  @Override
  public @NonNull T compose(
    @NonNull Map<String, Value> source,
    @NonNull Neo4jConversionService neo4jConversionService
  ) {
    return MapToObject.convert(this.clazz, source);
  }
}
