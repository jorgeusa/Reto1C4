/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.services;

import com.Reto1.reto1.app.model.User;
import com.Reto1.reto1.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service //definimos nuestro servicio
public class UserService 
{
    @Autowired //inyeccion de depedencias
    private UserRepository repository;
    
    public List<User> getAll()
    {
        return repository.getAll(); 
    }
    
    public User save(User user)
    {
        if(user.getId()==null)
        {
           
            List<User> existUsers = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            
            if(existUsers.isEmpty())
            {
                return repository.save(user);
            }
            else
            {
                return user;
            }
            
        }
        else
        {
            Optional<User> existUser = repository.getUserById(user.getId());
            if(existUser.isEmpty())
            {
                return repository.save(user);
            }
            else
            {
                return user;
            }
            
        }
    }
    
    public boolean getUserByEmail(String email)
    {
        return repository.getUserByEmail(email).isPresent();
        
    }
    
    public User getUserByEmailAndPassword(String email,String password)
    {
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if(user.isPresent())
        {
            return user.get();
        }
        else
        {
            return new User(null,email,password,"NO DEFINIDO");
        }
    }
    
}
