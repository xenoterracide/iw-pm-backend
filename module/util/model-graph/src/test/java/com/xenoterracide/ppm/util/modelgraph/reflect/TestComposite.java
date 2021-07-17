/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph.reflect;

import com.xenoterracide.ppm.util.modelgraph.AbstractMapToObjectConverter;

public class TestComposite {

  private final String aString;

  public TestComposite(String aString) {
    this.aString = aString;
  }

  public String getaString() {
    return aString;
  }

  public static class Converter
    extends AbstractMapToObjectConverter<TestComposite> {

    protected Converter() {
      super(TestComposite.class);
    }
  }
}
