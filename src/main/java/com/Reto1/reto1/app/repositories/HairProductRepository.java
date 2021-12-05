/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.repositories;

import com.Reto1.reto1.app.model.HairProduct;
import com.Reto1.reto1.app.repositories.crud.HairProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorge
 */
@Repository
public class HairProductRepository {

    @Autowired //inyeccion de dependencias
    private HairProductCrudRepository repository;

    public List<HairProduct> getAll() {
        return (List<HairProduct>) repository.findAll();
    }

    public Optional<HairProduct> getHairProductById(String id) {
        return repository.findById(id);
    }

    public HairProduct save(HairProduct hairproduct) {
        return repository.save(hairproduct);
    }
    

    public void delete(String id) {
        repository.deleteById(id);
    }
    
    public Optional<HairProduct> getHairProductByReference(String reference)
    {
        return repository.findByReference(reference);
    }

}
