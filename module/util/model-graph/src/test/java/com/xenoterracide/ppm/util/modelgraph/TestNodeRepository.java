/*
 * Copyright © 2021 Caleb Cushing.
 * Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE
 * https://choosealicense.com/licenses/apache-2.0/#
 */
package com.xenoterracide.ppm.util.modelgraph;

import java.util.UUID;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TestNodeRepository extends Neo4jRepository<TestNode, UUID> {}
