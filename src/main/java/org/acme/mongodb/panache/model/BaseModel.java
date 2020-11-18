/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acme.mongodb.panache.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author seseso
 */
public class BaseModel implements Serializable {
    
    public Integer legacyId;
    public String createdBy;
    public LocalDateTime createdAt;
    public String lastUpdatedBy;
    public LocalDateTime lastUpdatedAt;
}
