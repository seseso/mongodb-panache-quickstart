/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acme.mongodb.panache;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.inject.Inject;
import org.acme.mongodb.panache.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author seseso
 */
@QuarkusMain
public class App implements QuarkusApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    @Inject
    RepositoryPerson repo;
    
    @Override
    public int run(String... args) throws Exception {
        
        
        Person entity = new Person();
        entity.name = "John Doe";
        entity.birthDate = LocalDate.of(2001, 4, 26);
        
        entity.legacyId = 1;
        entity.createdBy = "me";
        entity.createdAt = LocalDateTime.now();
        
        repo.persistOrUpdate(entity);
        
        LOGGER.info("Inserted person with legacyId {} and name {}", entity.legacyId, entity.name);
        
        LOGGER.info("Found persons with legacyId = 1: {}", repo.find("legacyId", 1).count());
        
        LOGGER.info("Found persons with name = John Doe: {}", repo.find("name", "John Doe").count());
        
        return 0;
    }
    
}
