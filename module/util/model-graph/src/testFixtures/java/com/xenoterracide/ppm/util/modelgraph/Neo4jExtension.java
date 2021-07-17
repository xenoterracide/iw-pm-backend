/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

class Neo4jExtension implements BeforeAllCallback, AfterAllCallback {

  /** can't access {@link SpringExtension.TEST_CONTEXT_MANAGER_NAMESPACE } **/
  private static final Namespace SPRING_TEST_NS = Namespace.create(
    SpringExtension.class
  );

  private static GenericApplicationContext getApplicationContext(
    ExtensionContext ext
  ) {
    return (GenericApplicationContext) ext
      .getRoot()
      .getStore(SPRING_TEST_NS)
      .get(ext.getRequiredTestClass(), TestContextManager.class)
      .getTestContext()
      .getApplicationContext();
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    getApplicationContext(context).getBean(Neo4j.class).close();
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    var springContext = getApplicationContext(context);
    springContext.registerBean(
      Neo4j.class,
      () -> {
        var neo4j = Neo4jBuilders
          .newInProcessBuilder()
          .withDisabledServer()
          .build();
        System.setProperty("spring.neo4j.uri", neo4j.boltURI().toString());
        System.setProperty("spring.neo4j.authentication.username", "neo4j");
        return neo4j;
      }
    );
  }
}
