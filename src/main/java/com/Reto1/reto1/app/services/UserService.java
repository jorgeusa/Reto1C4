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
public class UserService {

    @Autowired //inyeccion de depedencias
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }
    
    public Optional<User> getUserById(Integer id)
    {
        return repository.getUserById(id);
        
    }

    public User save(User user) {
        if (user.getId() == null) {
            return user;
        } else {

            if (user.getIdentification() == null || user.getEmail() == null || user.getName() == null || user.getPassword() == null || user.getType() == null) {
                return user;
            } else {
                List<User> userExist = repository.getUserByIdOrEmailOrName(user.getId(), user.getEmail(), user.getName());
                if (userExist.isEmpty()) {
                    return repository.save(user);

                }
                else
                {
                    return user;
                }
                
            }

        }

    }

    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();

    }

    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            return new User();
        }
    }

    public User update(User user) {
        Optional<User> userExist = repository.getUserById(user.getId());
        if(userExist.isPresent())
        {
            if(user.getIdentification()!=null)
            {
                userExist.get().setIdentification(user.getIdentification());
            }
            
            if(user.getName()!=null)
            {
                userExist.get().setName(user.getName());
            }
            
            if(user.getAddress()!=null)
            {
                userExist.get().setAddress(user.getAddress());
            }
            if(user.getCellPhone()!=null)
            {
                userExist.get().setCellPhone(user.getCellPhone());
            }
            if(user.getType()!=null)
            {
                userExist.get().setType(user.getType());
            }
            if(user.getZone()!=null)
            {
                userExist.get().setZone(user.getZone());
            }
            if(user.getEmail()!=null)
            {
                userExist.get().setEmail(user.getEmail());
            }
            if(user.getPassword()!=null)
            {
                userExist.get().setPassword(user.getPassword());
            }
            
            return repository.save(userExist.get());
        }
        else
        {
            return user;
        }
    }

    public boolean delete(Integer id) 
    {
        Boolean aBoolean = getUserById(id).map(user -> {
            repository.delete(user.getId());
            return true;
        
        }).orElse(false);
          
        return aBoolean;
        
    }

}
