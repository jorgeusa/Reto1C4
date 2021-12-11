/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.model;

import java.util.Date;
import java.util.Map;
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
@Document(collection = "order")
public class Order 
{
    public static String PENDING = "pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "rechazada";
    
    @Id
    private Integer id;
    
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<String, HairProduct> products;
    private Map<String, Integer> quantities;
    
    
}
