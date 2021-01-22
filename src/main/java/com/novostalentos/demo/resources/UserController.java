package com.novostalentos.demo.resources;

import com.novostalentos.demo.service.UserService;
import com.novostalentos.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/crud")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User>  save(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.salvar(user));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity <User> findUserID(@PathVariable("id") int id){
        return new ResponseEntity(userService.buscarID(id), HttpStatus.OK);
    }

    @GetMapping("/find-all")
    public List<User> findAll(){return userService.buscarAll();}

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody User user) {
        return ResponseEntity.ok(userService.alteracao(id, user));
    }

    @DeleteMapping(path ={"/delete/{id}"})
    public ResponseEntity<Void> delete(@PathVariable int id) {
        userService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}