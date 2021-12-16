/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Reto1.reto1.app.repositories.crud;

import com.Reto1.reto1.app.model.HairProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author jorge
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct,String>
{
  public Optional<HairProduct> findById(String id);
  public Optional<HairProduct> findByReference(String reference);
  @Query("{'price': {$lte:?0}}")
  List<HairProduct> findByPrice(double price);
  
  @Query("{'description': {$regex:?0,$options:'i'}}")
  List<HairProduct> findByDescription(String description);
      
}
