package com.example.jpaentitygraphstoredprocedurecallback.service;

import com.example.jpaentitygraphstoredprocedurecallback.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {
      @Autowired
      ClientService clientService;

      @Test
      void findByNameContainingEmNative() {
            List<Client> result = clientService.findByNameContainingEmNative("Ren");
      }

      @Test
      void findByNameContaining() {
            List<Client> result = clientService.findByNameContaining("Ren");
      }
}