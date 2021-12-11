/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.services;

import com.Reto1.reto1.app.model.Order;
import com.Reto1.reto1.app.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class OrderService 
{
    @Autowired
    private OrderRepository repository;
    
    public List<Order> getAll() {
        return repository.getAll();
    }
    
    public Optional<Order> getOrderById(Integer id)
    {
        return repository.getOrderById(id);
        
    }
    
    public Order save(Order order) {
        if (order.getId() == null) {
            return order;
        } else {

            if (order.getProducts() == null || order.getQuantities() == null || order.getRegisterDay() == null || order.getSalesMan() == null || order.getStatus() == null) {
                return order;
            } else {
                Optional<Order> orderExist = repository.getOrderById(order.getId());
                if (orderExist.isEmpty()) {
                    return repository.save(order);

                }
                else
                {
                    return order;
                }
                
            }

        }

    }
    
    
    public Order update(Order order) {
        Optional<Order> orderExist = repository.getOrderById(order.getId());
        if(orderExist.isPresent())
        {
      
            
            if(order.getProducts()!=null)
            {
                orderExist.get().setProducts(order.getProducts());
            }
            
            if(order.getQuantities()!=null)
            {
                orderExist.get().setQuantities(order.getQuantities());
            }
            if(order.getRegisterDay()!=null)
            {
                orderExist.get().setRegisterDay(order.getRegisterDay());
            }
            if(order.getSalesMan()!=null)
            {
                orderExist.get().setSalesMan(order.getSalesMan());
            }
            if(order.getStatus()!=null)
            {
                orderExist.get().setStatus(order.getStatus());
            }
            
            
            return repository.save(orderExist.get());
        }
        else
        {
            return order;
        }
    }
    
    
    
    
    
    public boolean delete(Integer id) 
    {
        Boolean aBoolean = getOrderById(id).map(order -> {
            repository.delete(order.getId());
            return true;
        
        }).orElse(false);
          
        return aBoolean;
        
    }
    
    public List<Order> getOrderByZone(String country)
    {
        List<Order> order = repository.getOrderByZone(country);
        if(order.isEmpty())
        {
            return null;
        }
        else
        {
            return repository.getOrderByZone(country);
        }
    }
    
    
    
}
