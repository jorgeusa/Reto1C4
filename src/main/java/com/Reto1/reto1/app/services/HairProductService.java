/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.services;

import com.Reto1.reto1.app.model.HairProduct;
import com.Reto1.reto1.app.repositories.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */

@Service
public class HairProductService {

    @Autowired //inyeccion de depedencias
    private HairProductRepository repository;

    public List<HairProduct> getAll() {
        return repository.getAll();
    }
    
    public Optional<HairProduct> getByReference(String reference)
    {
        return repository.getHairProductById(reference);
        
    }
    
    /* public HairProduct save(HairProduct hairproduct) {
        if (hairproduct.getReference() == null) {
            return hairproduct;
        } else {

            if (hairproduct.getReference() == null || hairproduct.getBrand() == null || hairproduct.getCategory() == null || hairproduct.getDescription() == null || hairproduct.getName() == null || hairproduct.getPhotography()==null) {
                return hairproduct;
            } else {
                List<HairProduct> userExist = repository.getByNameAndReference(hairproduct.getName(),hairproduct.getReference());
                if (userExist.isEmpty()) {
                    return repository.save(hairproduct);

                }
                else
                {
                    return hairproduct;
                }
                
            }

        }

    }*/
    

   public HairProduct save(HairProduct hairproduct) {
        if (hairproduct.getReference()== null) {
            return hairproduct;
        } else {
            Optional<HairProduct> productExist = repository.getHairProductById(hairproduct.getReference());
            if (productExist.isEmpty()) {
                return repository.save(hairproduct);
            } else {
                return hairproduct;
            }

        }

    }
    
   
    
    

    public HairProduct update(HairProduct hairproduct) {
        Optional<HairProduct> productExist = repository.getHairProductByReference(hairproduct.getReference());
        
        if (productExist.isPresent()) {
           
            if (hairproduct.getBrand() != null) {
                productExist.get().setBrand(hairproduct.getBrand());
            }
            if (hairproduct.getCategory() != null) {
                productExist.get().setCategory(hairproduct.getCategory());
            }
            if (hairproduct.getName() != null) {
                productExist.get().setName(hairproduct.getName());
            }
            if (hairproduct.getDescription() != null) {
                productExist.get().setDescription(hairproduct.getDescription());
            }
            if (hairproduct.isAvailability()) {
                productExist.get().setAvailability(hairproduct.isAvailability());
            }
            if (hairproduct.getPrice() != 0) {
                productExist.get().setPrice(hairproduct.getPrice());
            }
            if (hairproduct.getQuantity() != 0) {
                productExist.get().setQuantity(hairproduct.getQuantity());
            }
            if (hairproduct.getPhotography() != null) {
                productExist.get().setPhotography(hairproduct.getPhotography());
            }
           

            return repository.save(productExist.get());

        } else 
        {
            return hairproduct;
            
        }
    }
    
    
    public boolean delete(String id) 
    {
        Boolean aBoolean = repository.getHairProductByReference(id).map(hairproduct -> {
            repository.delete(hairproduct.getReference());
            return true;
        
        }).orElse(false);
          
        return aBoolean;
        
    }

    /*public boolean delete(String reference) {
        Boolean aBoolean = repository.getHairProductByReference(reference).map(product -> {
            repository.delete(product.getReference());
            return true;

        }).orElse(false);

        return aBoolean;

    }*/

}
