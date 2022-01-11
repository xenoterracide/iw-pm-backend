/*
 * Copyright © 2021-2022 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import com.xenoterracide.ppm.util.modelgraph.reflect.TestComposite;
import java.util.UUID;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class TestNode extends AbstractGraphEntity {

  @CompositeProperty(converter = TestComposite.Converter.class)
  private final TestComposite testComposite;

  public TestNode(TestComposite testComposite) {
    this.testComposite = testComposite;
  }

  @PersistenceConstructor
  TestNode(TestComposite testComposite, UUID id) {
    super(id, 0);
    this.testComposite = testComposite;
  }

  public TestComposite getTestComposite() {
    return testComposite;
  }
}
