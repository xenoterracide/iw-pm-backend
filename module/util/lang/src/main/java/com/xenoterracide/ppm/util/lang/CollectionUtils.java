/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.lang;

import java.util.Collection;

public final class CollectionUtils {

  private CollectionUtils() {
  }

  public static <E, C extends Collection<E>> C requireNonEmpty( C collection ) {
    if ( collection.isEmpty() ) {
      throw new IllegalStateException( "collection is empty" );
    }
    return collection;
  }
}
