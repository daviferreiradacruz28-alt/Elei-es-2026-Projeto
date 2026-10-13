package com.example;

public class Candidato {
    private String nome;
    private String partido;
    private int numero;
    private int votos;
    
    public Candidato(String nome, String partido, int numero) {
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getPartido() {
        return this.partido;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public int getVotos() {
        return this.votos;
    }
    
    public int ganhouVoto() {
        int votou = this.votos += 1;
        return votou;
    }
}