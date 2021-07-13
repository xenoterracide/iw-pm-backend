module ppm.user.model {
  requires java.base;
  requires ppm.util.modelgraph;
  requires static org.checkerframework.checker.qual;
  requires org.neo4j.driver;
  requires org.neo4j.cypherdsl.core;
  requires spring.context;
  requires spring.data.commons;
  requires spring.data.neo4j;
  opens com.xenoterracide.ppm.user.model to spring.core;
  exports com.xenoterracide.ppm.user.model;
}
