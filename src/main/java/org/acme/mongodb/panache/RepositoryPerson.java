/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acme.mongodb.panache;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;
import org.acme.mongodb.panache.model.Person;

/**
 *
 * @author seseso
 */
@ApplicationScoped
public class RepositoryPerson implements PanacheMongoRepository<Person> {
    
}
