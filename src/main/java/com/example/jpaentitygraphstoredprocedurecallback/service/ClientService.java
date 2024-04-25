package com.example.jpaentitygraphstoredprocedurecallback.service;

import com.example.jpaentitygraphstoredprocedurecallback.entity.Client;
import com.example.jpaentitygraphstoredprocedurecallback.entity.EmailAddress;
import com.example.jpaentitygraphstoredprocedurecallback.repository.ClientRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import net.datafaker.Faker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {
    @PersistenceContext
    private EntityManager entityManager;

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void generateDB(){
        List<Client> clients = create2000Clients();
        for (int i = 0; i < clients.size(); i++) {
            clientRepository.save(clients.get(i));
        }
    }


    public List<Client> create2000Clients() {
        List<Client> clients = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 2_000; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String sufixTel = String.valueOf(i);
            String telephone = "+375290000000";

            List<EmailAddress>emailAddresses= Arrays.asList(
                    new EmailAddress((firstName + lastName).toLowerCase() + "1" + i + "@gmail.com"),
                    new EmailAddress((firstName + lastName).toLowerCase() + "2" + i + "@gmail.com"));

            telephone = telephone.substring(0, telephone.length()-sufixTel.length()) + sufixTel;
            Client client = new Client(
                    firstName + " " + lastName,
                    telephone,
                    emailAddresses
            );

            for (EmailAddress emailAddress:emailAddresses) {
                emailAddress.setClient(client);
            }

            clients.add(client);
        }
        return clients;
    }

    public List<Client> findByNameContaining(String userName){
        List<Client> byFullNameContaining = clientRepository.findByFullNameContaining(userName);
        System.out.println("RESULT findByNameContaining ------------------------------------");
        System.out.println(byFullNameContaining);
        System.out.println("RESULT findByNameContaining ------------------------------------");
        return byFullNameContaining;
    }

    @Transactional()
    public List<Client> findByNameContainingEmNative(String userName) {
        Query nativeQuery = entityManager.createNativeQuery(" SELECT id, full_name, mobile_number, (SELECT email FROM email_address WHERE client_id = id) FROM client  WHERE full_name like CONCAT('%', ?1, '%') ", Client.class);
        nativeQuery.setParameter(1,userName);
        List resultList = nativeQuery.getResultList();
        System.out.println("RESULT findByNameContainingEmNative ------------------------------------");
        System.out.println(resultList);
        System.out.println("RESULT findByNameContainingEmNative ------------------------------------");
        return resultList;
    }

    public List<Client> findByNameContainingJPQL(String userName) {

    }

}