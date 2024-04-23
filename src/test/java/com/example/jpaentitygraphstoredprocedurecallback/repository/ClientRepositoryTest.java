package com.example.jpaentitygraphstoredprocedurecallback.repository;

import com.example.jpaentitygraphstoredprocedurecallback.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientRepositoryTest {
      @Autowired
      ClientRepository clientRepository;

      @Test
      void findByFullNameContainingNative() {
            String ren = "Marcelene Funk";
            List<Client> result = clientRepository.findByFullNameContainingNative(ren);
            System.out.println(result);
      }
}