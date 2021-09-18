/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;

class Neo4jExtension implements BeforeAllCallback, AfterAllCallback {

  @Nullable
  private Neo4j neo4j;

  @Override
  public void afterAll(ExtensionContext context) {
    if (neo4j != null) {
      neo4j.close();
    }
  }

  @Override
  public void beforeAll(ExtensionContext context) {
    neo4j = Neo4jBuilders.newInProcessBuilder().withDisabledServer().build();

    System.setProperty("spring.neo4j.uri", this.neo4j.boltURI().toString());
    System.setProperty("spring.neo4j.authentication.username", "neo4j");
  }
}
