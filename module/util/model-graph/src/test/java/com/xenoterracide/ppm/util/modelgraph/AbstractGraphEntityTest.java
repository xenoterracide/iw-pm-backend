/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import static org.assertj.core.api.Assertions.assertThat;

import com.xenoterracide.ppm.util.modelgraph.reflect.TestComposite;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class AbstractGraphEntityTest {

  @Test
  void equalsHashCode() {
    EqualsVerifier
      .forClass(TestNode.class)
      .suppress(Warning.NONFINAL_FIELDS)
      .withOnlyTheseFields("id")
      .verify();
  }

  @Test
  void string() {
    var node = new TestNode(new TestComposite("a"));
    assertThat(node.toString()).contains("id=");
  }
}
