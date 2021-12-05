/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.reto1.app.repositories;

import com.Reto1.reto1.app.model.User;
import com.Reto1.reto1.app.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorge
 */
@Repository //nos genera nuestro repositorio
public class UserRepository {

    @Autowired //inyeccion de dependencias
    private UserCrudRepository repository;

    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    public Optional<User> getUserByName(String name) {
        return repository.findByName(name);
    }

    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     *
     * @param name
     * @param email
     * @return
     */
    public List<User> getUserByNameOrEmail(String name, String email) {
        return repository.findByNameOrEmail(name, email);

    }

    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);

    }

    public Optional<User> getUserById(Integer id) {
        return repository.findById(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<User> getUserByIdOrEmailOrName(Integer id, String email, String name) {
        return repository.findByIdOrEmailOrName(id, email, name);
    }
    
    

}
