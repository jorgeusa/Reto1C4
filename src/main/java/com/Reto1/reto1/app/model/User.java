/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.model;

import java.util.Date;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jorge
 */
@Data //nos genera los getter and setter
@NoArgsConstructor //nos genera constructor sin argumentos
@AllArgsConstructor // nos genera constructor con todos argumentos
@Document(collection = "user")
public class User {

    @Id
    private Integer id;

    private String identification;

    private String name;

    private Date birthtDay;

    private String monthBirthtDay;

    private String address;

    private String cellPhone;

    private String email;

    private String password;

    private String zone;

    private String type;

}
