package com.unibratec.laisvidoto.application_exemplo_sqlite;

import java.io.Serializable;

public class Aluno implements Serializable
{
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    @Override
    public String toString()
    {
        return nome;
    }

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelefone()
    {
        return telefone;
    }
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
}
