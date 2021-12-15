/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.controller;

import com.Reto1.reto1.app.model.Order;
import com.Reto1.reto1.app.services.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge
 */

@RestController
@RequestMapping("order")
@CrossOrigin(origins="*") //habilita acceso desde cualquier origen
public class OrderController 
{
    @Autowired
    private OrderService service;
    
    @GetMapping("/all")
    public List<Order> getOrder()
    {
        return service.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order)
    {
        return service.save(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order)
    {
        return service.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id)
    {
        return service.delete(id);
    }
    
    @GetMapping("/zona/{country}")
    public List<Order> existZone(@PathVariable("country") String country)
    {
        return service.getOrderByZone(country);
    }
    @GetMapping("/{id}")
    public Optional<Order> existId(@PathVariable("id") Integer id)
    {
        return service.getOrderById(id);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManById(@PathVariable("id") Integer id)
    {
        return service.ordersSalesManById(id);
    }
    
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id)
    {
        return service.ordersSalesManByState(state, id);
    }
    
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String datestr, @PathVariable("id") Integer id)
    {
        return service.ordersSalesManByDate(datestr, id);
    }
}
