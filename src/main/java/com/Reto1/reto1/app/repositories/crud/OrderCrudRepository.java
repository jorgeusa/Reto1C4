/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Reto1.reto1.app.repositories.crud;

import com.Reto1.reto1.app.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author jorge
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> 
{
    //como el salesman es de tipo usuario, este tiene el atributo zona
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    
    //se retorna las ordenes segun su estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    /**
     *
     * @param id
     * @return
     */
    //@Query("'salesMan.id': ?0")
    //Optional<Order> findById(final Integer id);
    
    
}
