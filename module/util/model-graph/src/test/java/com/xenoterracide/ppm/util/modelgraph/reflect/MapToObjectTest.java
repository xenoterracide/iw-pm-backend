/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph.reflect;

import static org.assertj.core.api.Assertions.assertThat;
import static org.neo4j.driver.Values.value;

import java.util.Map;
import org.junit.jupiter.api.Test;

class MapToObjectTest {

  @Test
  void convert() {
    var aString = "hello";
    var entity = MapToObject.convert(
      TestComposite.class,
      Map.of("aString", value(aString))
    );
    assertThat(entity.getaString()).isEqualTo(aString);
  }
}
