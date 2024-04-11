package com.example.jpaentitygraphstoredprocedurecallback.repository;

import com.example.jpaentitygraphstoredprocedurecallback.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}