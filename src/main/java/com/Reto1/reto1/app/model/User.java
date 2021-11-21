/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author jorge
 */
@Data //nos genera los getter and setter
@NoArgsConstructor //nos genera constructor sin argumentos
@AllArgsConstructor // nos genera constructor con todos argumentos
@Entity
@Table(name = "user")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //defimos los datos que va a almacenar nuestra tabla
    private Integer id;
    @Column(name ="user_mail",unique = true, length = 50, nullable = false)
    private String email;
    @Column(name ="user_password", length = 50, nullable = false)
    private String password;
    @Column(name ="user_name",unique = true, length = 80, nullable = false)
    private String name;
    
    
}
