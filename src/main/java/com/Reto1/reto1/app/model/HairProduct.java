/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jorge
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hairproducts")
public class HairProduct {
    
    @Id
    private String reference;
    
    private String brand;

    private String category;

    private String name;

    private String description;

    private boolean availability = true;

    private double price;

    private int quantity;

    private String photography;

}
