module ppm.util.modelgraph {
  requires java.base;
  requires ppm.util.model;
  requires com.github.f4b6a3.uuid;
  requires spring.core;
  requires spring.beans;
  requires spring.data.commons;
  requires spring.data.neo4j;
  requires org.neo4j.driver;
  requires io.vavr;
  requires static org.apiguardian.api;
  requires static org.checkerframework.checker.qual;
  requires org.apache.commons.lang3;
  opens com.xenoterracide.ppm.util.modelgraph to spring.core;
  exports com.xenoterracide.ppm.util.modelgraph ;
}
