/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph.reflect;

import io.vavr.control.Try;
import java.util.Map;
import org.neo4j.driver.Value;
import org.springframework.data.util.ReflectionUtils;

public final class MapToObject {

  private MapToObject() {}

  public static <T> T convert(Class<T> clazz, Map<String, Value> source) {
    var args = source.values().stream().map(Value::asObject).toArray();
    return ReflectionUtils
      .findConstructor(clazz, args)
      .map(c -> Try.of(() -> c.newInstance(args)))
      .flatMap(io.vavr.Value::toJavaOptional)
      .map(clazz::cast)
      .orElseThrow();
  }
}
