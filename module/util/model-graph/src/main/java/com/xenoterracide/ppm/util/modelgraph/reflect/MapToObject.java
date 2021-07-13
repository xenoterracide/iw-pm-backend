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

  /*
  private static final Map<Class<?>, MultiValueMap<Constructor<?>, Parameter>> CLASSES
    = new HashMap<>();
   */

  public static <T> T convert(Class<T> clazz, Map<String, Value> source) {
    /*
    if ( !CLASSES.containsKey( clazz ) ) {
      CLASSES.put( clazz, new LinkedMultiValueMap<>() );
      for ( var constructor : clazz.getConstructors() ) {
        CLASSES.get( clazz ).put( constructor, List.of( constructor.getParameters() ) );
      }
    }

    for ( var entry : CLASSES.get( clazz ).entrySet() ) {
      var constructor = entry.getKey();
      var params = entry.getValue();
      if ( constructor.getParameterCount() == source.size() ) {
        var matches = params.stream()
          .map( Parameter::getName )
          .anyMatch( Predicate.not( source::containsKey ) );

        if ( matches ) {
          ;
        }
      }
    }

     */
    var args = source.values().stream().map(Value::asObject).toArray();
    return ReflectionUtils
      .findConstructor(clazz, args)
      .map(c -> Try.of(() -> c.newInstance(args)))
      .flatMap(io.vavr.Value::toJavaOptional)
      .map(clazz::cast)
      .orElseThrow();
  }
}
