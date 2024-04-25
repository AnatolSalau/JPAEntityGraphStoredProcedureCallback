package com.example.jpaentitygraphstoredprocedurecallback.repository;

import com.example.jpaentitygraphstoredprocedurecallback.entity.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
      /**
       @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
       private List<EmailAddress> emailAddresses; -- name that we put in attributePaths = "emailAddresses"
       */
      //@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "emailAddresses")

      @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "client_entity-graph")
      List<Client> findByFullNameContaining(String name);

}