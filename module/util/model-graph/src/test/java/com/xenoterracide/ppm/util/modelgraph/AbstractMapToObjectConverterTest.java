/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import static org.assertj.core.api.Assertions.assertThat;

import com.xenoterracide.ppm.util.modelgraph.reflect.TestComposite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DataNeo4jTest
class AbstractMapToObjectConverterTest {

  private final TestNodeRepository repository;

  @Autowired
  AbstractMapToObjectConverterTest(TestNodeRepository repository) {
    this.repository = repository;
  }

  @Test
  void compose() {
    var aString = "hello";
    var saved = repository.save(new TestNode(new TestComposite(aString)));
    assertThat(saved.getTestComposite().getaString()).isEqualTo(aString);
  }
}
