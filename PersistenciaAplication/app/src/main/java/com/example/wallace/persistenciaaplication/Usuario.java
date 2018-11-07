package com.example.wallace.persistenciaaplication;

public class Usuario {

    private String nome;
    private String senha;
    private String nomeCompleto;


    public Usuario(String nome, String senha, String nomeCompleto) {
        this.nome = nome;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
