package com.novostalentos.demo.service;

import com.novostalentos.demo.model.User;
import com.novostalentos.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User salvar(User user){
        return userRepository.save(user);
    }


    public User buscarID(int id){
        return userRepository.getOne(id);
    }

    public List<User> buscarAll (){
        return userRepository.findAll();
    }

    //public User alteracao(int id, User user){
    //    user.setId(id);
    //    return salvar(user);
    //}

    public User alteracao(int id, User user){
        User userAtualizado = buscarID(id);
        userAtualizado.setIdade(user.getIdade());
        userAtualizado.setEmail(user.getEmail());
        return salvar(userAtualizado);
    }

    public void deletar(int id){
        userRepository.deleteById(id);
    }
}