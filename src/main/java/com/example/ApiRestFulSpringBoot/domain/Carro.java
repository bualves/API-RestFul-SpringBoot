package com.example.ApiRestFulSpringBoot.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Carro
{
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto incremento do ID
    private Long id;

    @Column (name = "nome") //caso fosse diferente a coluna do banco
    private String nome;

    public Carro ()
    {

    }

    public Carro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
