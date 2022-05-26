package com.example.ApiRestFulSpringBoot.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Carro
{
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento do ID
    private Long id;

    @Column (name = "nome") //caso fosse diferente a coluna do banco
    private String nome;
    private String tipo;





}
