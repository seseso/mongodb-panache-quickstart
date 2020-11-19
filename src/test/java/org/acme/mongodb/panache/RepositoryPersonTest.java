/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acme.mongodb.panache;

import io.quarkus.test.junit.QuarkusTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.inject.Inject;
import org.acme.mongodb.panache.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author seseso
 */
@QuarkusTest
public class RepositoryPersonTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryPersonTest.class);
    
    @Inject
    RepositoryPerson repo;
    
    @Test
    public void test() {
        
        // Clean collection
        repo.deleteAll();
        
        Person entity = new Person();
        entity.name = "John Doe";
        entity.birthDate = LocalDate.of(2001, 4, 26);
        entity.status = Person.Status.ALIVE;
        
        entity.legacyId = 1;
        entity.createdBy = "me";
        entity.createdAt = LocalDateTime.now();
        
        repo.persistOrUpdate(entity);
        
        LOGGER.info("Inserted person with status: name: {}, toString: {}", entity.status.name(), entity.status.toString());
        
        Optional<Person> personByStatusToString = repo.find("status", Person.Status.ALIVE).singleResultOptional();
        
        Optional<Person> personByStatusName = repo.find("status", Person.Status.ALIVE.name()).singleResultOptional();
       
        LOGGER.info("Found person with status: name: {}, toString: {}", personByStatusName.isPresent(), personByStatusToString.isPresent());
        
        
    }
}
