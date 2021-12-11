/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.repositories;

import com.Reto1.reto1.app.model.Order;
import com.Reto1.reto1.app.repositories.crud.OrderCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
}
