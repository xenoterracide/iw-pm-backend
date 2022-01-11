/*
 * Copyright © 2022 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.lang;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class CollectionsTest {

  @Test
  void requireNonEmptyEmpty() {
    assertThatThrownBy(() -> Collections.requireNonEmpty(new ArrayList<>()))
      .hasCauseExactlyInstanceOf(IllegalStateException.class);
  }
}
