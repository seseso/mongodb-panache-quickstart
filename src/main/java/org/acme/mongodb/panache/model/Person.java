/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acme.mongodb.panache.model;

import java.time.LocalDate;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author seseso
 */
public class Person extends BaseModel {
    public String name;

    // will be persisted as a 'birth' field in MongoDB
    @BsonProperty("birth")
    public LocalDate birthDate;

    public Status status;
    
    
    public enum Status {
        ALIVE,
        DEATH;
    }
}
