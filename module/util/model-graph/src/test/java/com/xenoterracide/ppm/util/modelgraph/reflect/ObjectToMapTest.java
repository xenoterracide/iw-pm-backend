/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph.reflect;

import static org.assertj.core.api.Assertions.assertThat;
import static org.neo4j.driver.Values.value;

import org.junit.jupiter.api.Test;

class ObjectToMapTest {

  @Test
  void convert() {
    var aString = "hello";
    var map = ObjectToMap.convert(new TestEntity(aString));
    assertThat(map).containsEntry("aString", value(aString));
  }

  static class TestEntity {

    private final String aString;

    TestEntity(String aString) {
      this.aString = aString;
    }

    public String getaString() {
      return aString;
    }
  }
}
