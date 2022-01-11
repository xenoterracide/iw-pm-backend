/*
 * Copyright © 2021-2022 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.Neo4jContainer;

class Neo4jExtension implements BeforeAllCallback, AfterAllCallback {

  @Nullable
  private Neo4jContainer<?> neo4j;

  @Override
  public void afterAll(ExtensionContext context) {
    if (neo4j != null) {
      neo4j.close();
    }
  }

  @Override
  public void beforeAll(ExtensionContext context) {
    neo4j = new Neo4jContainer<>("neo4j:latest");
    neo4j.start();

    System.setProperty("spring.neo4j.uri", this.neo4j.getBoltUrl());
    System.setProperty("spring.neo4j.authentication.username", "neo4j");
    System.setProperty(
      "spring.neo4j.authentication.password",
      this.neo4j.getAdminPassword()
    );
  }
}
