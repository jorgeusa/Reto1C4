/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Reto1.reto1.app.repositories.crud;

import com.Reto1.reto1.app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author jorge
 */
       
public interface UserCrudRepository  extends MongoRepository<User,Integer>
{
    //Select * from user where user_name='algo'
    public Optional<User> findByName(String name);
    
    //Es los mismo que en sql
    //Select * from user where user_name = 'algo' or user_email = 'algo@algo.com'

    /**
     *
     * @param name
     * @param email
     * @return
     */
    public List<User> findByNameOrEmail(String name, String email);
    
    // Select * from user where user_email='algo@algo.com'
    public Optional<User> findByEmail(String email);
    
    //Select * from user where user_email='algo@algo.com' and user_password = 'algo'
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    public Optional<User> findById(Integer id);
    /**
     * 
     * @param id
     * @param email
     * @param name
     * @return 
     */
    public List<User> findByIdOrEmailOrName(Integer id, String email, String name);
}
