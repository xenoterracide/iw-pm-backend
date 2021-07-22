/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.jupiter.api.extension.ExtendWith;

@org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(Neo4jExtension.class)
public @interface DataNeo4jTest {
}
