package com.novostalentos.demo.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int Id;

@Column(name = "NOME")
private String Name;

@Column(name = "IDADE")
private int Idade;

@Column(name = "EMAIL")
private String Email;

}