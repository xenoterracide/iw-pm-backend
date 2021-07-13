/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph.reflect;

import static org.neo4j.driver.Values.value;

import java.util.HashMap;
import java.util.Map;
import org.neo4j.driver.Value;
import org.neo4j.driver.exceptions.ClientException;
import org.springframework.util.ReflectionUtils;

public final class ObjectToMap {

  private ObjectToMap() {
  }

  public static <T> Map<String, Value> convert(T property) {
    var map = new HashMap<String, Value>();
    ReflectionUtils.doWithFields(
      property.getClass(),
      f -> {
        ReflectionUtils.makeAccessible(f);
        var value = f.get(property);
        var name = f.getName();
        try {
          map.put(name, value(value));
        }
        catch (ClientException e) {
          map.put(name, value(convert(value)));
        }
      }
    );
    return map;
  }
}
