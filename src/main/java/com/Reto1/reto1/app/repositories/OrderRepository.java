/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.repositories;

import com.Reto1.reto1.app.model.Order;
import com.Reto1.reto1.app.repositories.crud.OrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorge
 */
@Repository

public class OrderRepository 
{
    @Autowired //inyeccion de dependencias
    private OrderCrudRepository repository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    
    public List<Order> getAll() {
        return (List<Order>) repository.findAll();
    }
    
    public Optional<Order> getOrderById(Integer id) {
        return repository.findById(id);
    }
    
    public Order save(Order order) {
        return repository.save(order);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
    public List<Order> getOrderByZone(String country)
    {
        return repository.findByZone(country);
    }
    
    public List<Order> getOrderByStatus(String status)
    {
        return repository.findByStatus(status);
    }
    public List<Order> ordersSalesManById(Integer id)
    {
        Query query = new Query();
        
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        
        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
        
    }
    
    public List<Order> ordersSalesManByState(String state, Integer id)
    {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id).and("status").is(state);
        query.addCriteria(criterio);
        
        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
    }
    
    public List<Order> ordersSalesManByDate(String datestr, Integer id)
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria criterio = Criteria.where("registerDay").gte(LocalDate.parse(datestr, dft).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(datestr, dft).plusDays(2).atStartOfDay()).and("salesMan.id").is(id);
        
        
        query.addCriteria(criterio);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
        
    }
    
}
