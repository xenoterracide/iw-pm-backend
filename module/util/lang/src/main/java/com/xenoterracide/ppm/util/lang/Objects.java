/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.lang;

import org.checkerframework.checker.nullness.qual.Nullable;

public final class Objects {

  private Objects() {
  }

  public static <T> T requireNonNull(@Nullable T o, String message) {
    if (o == null) {
      throw new IllegalArgumentException(
        String.format("%s must not be null", message)
      );
    }
    return o;
  }
}
